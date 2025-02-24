/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleWebServer31 {

  @Test
  void test() throws Exception {
      var server = launchServer();
      var addr = server.getAddress();

      try (HttpClient client = HttpClient.newHttpClient()) {

        HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:" + addr.getPort() + "/lines.txt"))
          .GET()
          .build();

        HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        assertThat(response.body()).isEqualTo("""
          alpha
          bravo
          charlie
          """);
      }

      server.stop(0);
    }

    @Test
    void testHandler() throws Exception {
      var server = launchServer();
      var addr = server.getAddress();

      server.createContext("/hello", exchange -> {
        exchange.sendResponseHeaders(200, 0);
        exchange.getResponseBody().write("world".getBytes(StandardCharsets.UTF_8));
        exchange.close();
      });

      try (HttpClient client = HttpClient.newHttpClient()) {

        HttpRequest get = HttpRequest.newBuilder(URI.create("http://localhost:" + addr.getPort() + "/hello"))
          .GET()
          .build();

        HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        assertThat(response.body()).isEqualTo("world");
      }

      server.stop(1);
    }

    private static HttpServer launchServer() {
      var addr = new InetSocketAddress(0);
      var server = SimpleFileServer.createFileServer(addr,
        Path.of("src/test/data").toAbsolutePath(),
        SimpleFileServer.OutputLevel.INFO);
      server.start();
      return server;
    }
}

// jwebserver (port 8000)
// jwebserver -p 9000
// test()
// testHandler()

