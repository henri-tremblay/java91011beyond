/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
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
    authentication.set("password");
  }

  @Test
  public void test() throws Exception {
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

      List<Future<String>> bodies = urls.stream()
        .map(url -> executorService.submit(() -> retrieveBody(url)))
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
    }
  }

  private String retrieveBody(String url) throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder(URI.create(url))
      .GET()
      .header("Authorization", authentication.get())
      .build();
    return client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
  }

  // try-with-resource
  // pass a value to the thread local inside the thread
  // use a scoped value
  // use a structured scope

}
