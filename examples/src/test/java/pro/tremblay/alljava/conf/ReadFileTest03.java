/*
 * Copyright 2018-2022 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertThrows;

/**
 * @author Henri Tremblay
 */
public class ReadFileTest03 {

  public static List<String> readFile(String folder, String filename) {
    File file = new File(folder, filename);
    BufferedReader in;
    try {
      in = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
    }
    catch(FileNotFoundException e) {
      throw new UncheckedIOException(e);
    }
    try {
      List<String> list = new ArrayList<>();
      String s;
      while((s = in.readLine()) != null) {
        list.add(s);
      }
      return list;
    }
    catch(IOException e) {
      throw new UncheckedIOException(e);
    }
    finally {
      try {
        in.close();
      }
      catch(IOException e) {
        // ignore silently
      }
    }
  }

  @Test
  public void test() {
    List<String> actual = readFile("src/test/data", "lines.txt");
    assertThat(actual).contains("alpha", "bravo", "charlie");
  }

  private IOException closing = new IOException("Closing");

  @Test
  public void testSuppressed() throws IOException {
    // assertThrows(IOException.class, () -> in.read());

    assertThatThrownBy(this::readStuff)
      .hasMessage("Reading")
      .hasSuppressedException(closing);

  }

  private void readStuff() throws IOException {
    try(InputStream in = createMock(InputStream.class)) {
      expect(in.read()).andThrow(new IOException("Reading"));

      in.close();
      expectLastCall().andThrow(closing);

      replay(in);

      in.read();
    }
  }

}

// Use StandardCharsets
// Use Paths
// Use Files.newBufferedReader
// Show addSuppressed old way
// Use try-with-resource
// Files.readAllLines
