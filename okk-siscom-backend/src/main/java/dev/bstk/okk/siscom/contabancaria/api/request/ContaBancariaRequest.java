package dev.bstk.okk.siscom.contabancaria.api.request;

public record ContaBancariaRequest(
  String nome,
  String agencia,
  String conta,
  String gerente,
  String banco,
  String observacao
) {
}
