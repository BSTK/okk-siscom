package dev.bstk.okk.siscom.contabancaria.api.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ContaBancariaResponse(
  UUID id,
  String nome,
  String agencia,
  String conta,
  String gerente,
  String observacao
) { }
