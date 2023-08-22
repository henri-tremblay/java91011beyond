package pro.tremblay.alljava.conf;

import jdk.incubator.concurrent.StructuredTaskScope;
import org.junit.jupiter.api.Test;
import pro.tremblay.alljava.User;
import pro.tremblay.alljava.UserDao;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

class StructuredConcurrency35 {

  private final UserDao dao = new UserDao();

  @Test
  void test() throws Exception {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      List<Future<Integer>> ages = UserDao.NAMES.stream()
        .map(firstName -> scope.fork(() -> dao.find(firstName).getAge()))
        .toList();

      scope.join();
      scope.throwIfFailed();

      ages.stream()
        .map(Future::resultNow)
        .forEachOrdered(System.out::println);
    }
  }

  // Remember ParallelTest10?
  // StructuredTaskScope, add --add-modules=jdk.incubator.concurrent
  // ShutdownOnFailure
  // ShutdownOnSuccess and result()
}
