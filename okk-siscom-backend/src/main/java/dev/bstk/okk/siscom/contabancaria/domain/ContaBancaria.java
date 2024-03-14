package dev.bstk.okk.siscom.contabancaria.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ContaBancaria(
  Long id,

  @NotNull
  UUID uuid,

  @NotNull
  @NotEmpty
  String nome,

  @NotNull
  @NotEmpty
  String agencia,

  @NotNull
  @NotEmpty
  String conta,

  String gerente,
  String observacao,

  @NotNull
  LocalDateTime dataInsert,

  @NotNull
  LocalDateTime dataUpdate
) { }