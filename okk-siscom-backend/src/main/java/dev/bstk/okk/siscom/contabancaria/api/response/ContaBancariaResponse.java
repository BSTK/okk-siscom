package dev.bstk.okk.siscom.contabancaria.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaResponse {
  private UUID uuid;
  private String nome;
  private String agencia;
  private String conta;
  private String gerente;
  private String banco;
  private String observacao;
}
