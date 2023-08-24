package pro.tremblay.alljava.solutions;

import jdk.incubator.concurrent.ScopedValue;
import jdk.incubator.concurrent.StructuredTaskScope;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class ScopedValues36 {

  private final List<String> urls = List.of(
    "https://blog.tremblay.pro/about.html",
    "https://blog.tremblay.pro/allposts.html",
    "https://blog.tremblay.pro/friends.html"
  );

  private final HttpClient client = HttpClient.newHttpClient();

  private final ThreadLocal<String> authentication = new ThreadLocal<>();

  @BeforeEach
  void before() {
    authentication.set("pasword");
  }

  @Test
  public void test() throws Exception {
    ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    List<Future<String>> bodies = urls.stream()
      .map(url -> executorService.submit(() -> {
        return retrieveBody(url);
      }))
      .toList();

    bodies.stream()
      .map(future -> {
        try {
          return future.get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      })
      .forEach(System.out::println);

    executorService.shutdownNow();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
  }

  @Test
  void test1() throws Exception {
    ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    String auth = authentication.get();

    List<Future<String>> bodies = urls.stream()
      .map(url -> executorService.submit(() -> {
        authentication.set(auth);
        try {
          return retrieveBody(url);
        } finally {
          authentication.remove();
        }
      }))
      .toList();

    bodies.stream()
      .map(future -> {
        try {
          return future.get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      })
      .forEach(System.out::println);

    executorService.shutdownNow();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
  }

  private final ScopedValue<String> authScoped = ScopedValue.newInstance();

  @Test
  void test2() throws Exception {
    ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    List<Future<String>> bodies = urls.stream()
        .map(url -> executorService.submit(() -> ScopedValue.where(authScoped, "password", () -> retrieveBody(url))))
        .toList();

    bodies.stream()
      .map(future -> {
        try {
          return future.get();
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      })
      .forEach(System.out::println);

    executorService.shutdownNow();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
  }

  @Test
  void test3() throws Exception {
    ScopedValue.where(authScoped, "password", () -> doWork());
  }

  void doWork() {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      List<Future<String>> bodies = urls.stream()
        .map(url -> (Callable<String>) () -> retrieveBody(url))
        .map(scope::fork)
        .toList();

      scope.join();

      bodies.stream()
        .map(Future::resultNow)
        .forEach(System.out::println);
    } catch (InterruptedException e) {
        // do nothing
    }
  }

  private String retrieveBody(String url) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder(URI.create(url))
      .GET()
      .header("Authorization", authScoped.get())
      .build();
    return client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
  }

}
