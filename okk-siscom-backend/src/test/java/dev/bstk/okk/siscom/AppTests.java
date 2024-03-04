package dev.bstk.okk.siscom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

  @Test
  @DisplayName("Deve carregar o contexto do Spring Boot")
  void t1() {
      Assertions.assertDoesNotThrow(() -> {});
  }
}
