package dev.bstk.okk.siscom.core.domain;

import jakarta.persistence.AttributeConverter;

import java.util.Objects;
import java.util.UUID;

public class UUIDConverter implements AttributeConverter<UUID, String> {

  @Override
  public String convertToDatabaseColumn(final UUID uuid) {
    return Objects.nonNull(uuid)
      ? uuid.toString()
      : null;
  }

  @Override
  public UUID convertToEntityAttribute(final String uuidDb) {
    return Objects.nonNull(uuidDb)
      ? UUID.fromString(uuidDb)
      : null;
  }
}
