/*
 * Copyright 2018-2024 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

class HttpClient24 {

  @Test
  void callMyWebsite() throws Exception {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest get = HttpRequest.newBuilder(URI.create("https://blog.tremblay.pro"))
      .GET().build();

    CompletableFuture<HttpResponse<String>> response =
      client.sendAsync(get, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

    System.out.println(response.get().body());
  }
}
