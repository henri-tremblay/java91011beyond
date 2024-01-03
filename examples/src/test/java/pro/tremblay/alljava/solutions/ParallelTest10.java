/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.solutions;

import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;
import pro.tremblay.alljava.UserDao;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ParallelTest10 {

  private final UserDao userDao = new UserDao();

  @Test
  void averageSequential() {
    double averageAge = UserDao.NAMES
      .stream()
      .map(userDao::find)
      .mapToInt(User::getAge)
      .average()
      .orElseThrow(ArithmeticException::new);

    assertThat(averageAge).isEqualTo(33);
  }

  @Test
  void averageParallelThread() {
    AtomicLong value = new AtomicLong(0); // cheating
    CountDownLatch latch = new CountDownLatch(UserDao.NAMES.size()); // cheating
    for (String firstName : UserDao.NAMES) {
      new Thread(() -> {
        User user = userDao.find(firstName);
        value.addAndGet(user.getAge());
        latch.countDown();
      }).run();
    }

    try {
      latch.await();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    double averageAge = value.get() / UserDao.NAMES.size();
    assertThat(averageAge).isEqualTo(33);
  }

  @Test
  void averageParallelExecutor() throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(UserDao.NAMES.size());

    List<Callable<Integer>> callables = UserDao.NAMES.stream()
      .map(firstName -> (Callable<Integer>) () -> {
        User user = userDao.find(firstName);
        return user.getAge();
      })
      .collect(Collectors.toList());

    double averageAge = 0;

    try {
      averageAge = service.invokeAll(callables).stream()
        .mapToInt(future -> {
          try {
            return future.get();
          } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
          }
        })
        .average()
        .orElseThrow(ArithmeticException::new);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    service.shutdown();
    try {
      service.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    assertThat(averageAge).isEqualTo(33);
  }

  private class SumUserAge extends RecursiveTask<Long> {
    private final List<String> names;

    public SumUserAge(List<String> names) {
      this.names = names;
    }

    @Override
    protected Long compute() {
      if(names.isEmpty()) {
        return 0L;
      }
      if(names.size() == 1) {
        User user = userDao.find(names.get(0));
        return Long.valueOf(user.getAge());
      }
      int mid = names.size() / 2;
      SumUserAge s1 = new SumUserAge(names.subList(0, mid));
      s1.fork();
      SumUserAge s2 = new SumUserAge(names.subList(mid, names.size()));
      return s1.join() + s2.compute();
    }
  }

  @Test
  void averageParallelForkJoin() {
    long total;
    ForkJoinPool pool = new ForkJoinPool(UserDao.NAMES.size());
    try {
      total = pool.invoke(new SumUserAge(UserDao.NAMES));
    } finally {
      pool.shutdownNow();
    }

    double averageAge = total / UserDao.NAMES.size();
    assertThat(averageAge).isEqualTo(33);
  }

  @Test
  void averageParallelStream() {
    double averageAge = UserDao.NAMES
      .parallelStream()
      .map(userDao::find)
      .mapToInt(User::getAge)
      .average()
      .orElseThrow(ArithmeticException::new);

    assertThat(averageAge).isEqualTo(33);
  }

  @Test
  void averageCompletableFuture() throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> averageFuture =
      CompletableFuture.completedFuture(0);

    for (String firstName : UserDao.NAMES) {
      CompletableFuture<Integer> userFuture = CompletableFuture.supplyAsync(() -> userDao.find(firstName))
        .thenApply(User::getAge);
      averageFuture = averageFuture.thenCombine(userFuture, Integer::sum);
    }

    double averageAge = averageFuture.get() / UserDao.NAMES.size();

    assertThat(averageAge).isEqualTo(33);
  }

  class FirstNameToUserProcessor extends SubmissionPublisher<User> implements Flow.Processor<String, User> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
      this.subscription = subscription;
      subscription.request(1);
    }

    @Override
    public void onNext(String firstName) {
      submit(userDao.find(firstName));
      subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onComplete() {
    }
  }

  class UserToAgeProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<User, Integer> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
      this.subscription = subscription;
      subscription.request(1);
    }

    @Override
    public void onNext(User user) {
      submit(user.getAge());
      subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onComplete() {
    }
  }

  class SumSubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;
    private long total;
    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
      this.subscription = subscription;
      subscription.request(1);
    }

    @Override
    public void onNext(Integer age) {
      total += age;
      counter++;
      subscription.request(1);
    }

    @Override
    public void onError(Throwable error) {
    }

    @Override
    public void onComplete() {
    }

    public long getTotal() {
      return total;
    }
  }

  @Test
  void averageFlow() {
    SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

    FirstNameToUserProcessor firstNameToUserProcessor = new FirstNameToUserProcessor();
    UserToAgeProcessor userToAgeProcessor = new UserToAgeProcessor();
    SumSubscriber sumSubscriber = new SumSubscriber();

    publisher.subscribe(firstNameToUserProcessor);
    firstNameToUserProcessor.subscribe(userToAgeProcessor);
    userToAgeProcessor.subscribe(sumSubscriber);

    UserDao.NAMES.forEach(publisher::submit);

    while(UserDao.NAMES.size() != sumSubscriber.counter);

    publisher.close();

    double averageAge = sumSubscriber.getTotal() / UserDao.NAMES.size();
    assertThat(averageAge).isEqualTo(33);
  }
}

// Implement sequentially
// Use Thread
// Use ExecutorService
// Use ForkJoin
// Use parallel stream
// Use CompletableFuture
// Use Flow
