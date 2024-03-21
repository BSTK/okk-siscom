package dev.bstk.okk.siscom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

@Slf4j
public class AppTestExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

  private static boolean START = false;

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    if (!START) {
      START = true;
      AppTestContainer.startContainer();
      extensionContext.getRoot().getStore(GLOBAL).put(AppTestExtension.class.getName(), this);
    }
  }

  @Override
  public void close() {
    AppTestContainer.stopContainer();
  }
}