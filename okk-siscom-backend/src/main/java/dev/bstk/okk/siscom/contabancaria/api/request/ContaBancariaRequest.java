package dev.bstk.okk.siscom.contabancaria.api.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ContaBancariaRequest(
  @NotNull
  @NotEmpty
  String nome,

  @NotNull
  @NotEmpty
  String agencia,

  @NotNull
  @NotEmpty
  String conta,
  @NotNull
  @NotEmpty
  String banco,
  String gerente,
  String observacao
) {
}
