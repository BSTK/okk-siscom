package dev.bstk.okk.siscom.core.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UUIDConverterTest {


  private final UUIDConverter uuidConverter = new UUIDConverter();

  @Test
  @DisplayName("Deve converter um UUID para String")
  void t1() {
    final var uuid = UUID.randomUUID();
    final var resposta = uuidConverter.convertToDatabaseColumn(uuid);

    Assertions
      .assertThat(resposta)
      .isNotNull()
      .isNotEmpty()
      .isEqualTo(uuid.toString());
  }

  @Test
  @DisplayName("Deve retornar null ao tentar converter um UUID para String")
  void t2() {
    final var resposta = uuidConverter.convertToDatabaseColumn(null);

    Assertions
      .assertThat(resposta)
      .isNull();
  }

  @Test
  @DisplayName("Deve converter uma String para UUID")
  void t3() {
    final var uuid = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454";
    final var resposta = uuidConverter.convertToEntityAttribute(uuid);

    Assertions
      .assertThat(resposta)
      .isNotNull()
      .isEqualTo(UUID.fromString(uuid));
  }

  @Test
  @DisplayName("Deve retornar null ao tentar converter uma String para UUID")
  void t4() {
    final var resposta = uuidConverter.convertToEntityAttribute(null);

    Assertions
      .assertThat(resposta)
      .isNull();
  }
}
