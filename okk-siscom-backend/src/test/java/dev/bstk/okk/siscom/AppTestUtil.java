package dev.bstk.okk.siscom;

public class AppTestUtil {

  private static final String URL_BASE = "http://localhost:%s%s";

  private AppTestUtil() {}

  public static String url(final Integer portaHttp, final String urlPath) {
    return String.format("http://localhost:%s%s", portaHttp, urlPath);
  }
}
