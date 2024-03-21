package dev.bstk.okk.siscom;

public class AppTestUtil {

  private AppTestUtil() {}

  public static String url(final Integer portaHttp, final String urlPath) {
    return String.format("http://localhost:%s%s", portaHttp, urlPath);
  }
}
