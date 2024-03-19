package dev.bstk.okk.siscom.contabancaria.api.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaRequest {

  @NotNull(message = "Campo nome é obrigatório")
  @NotEmpty(message = "Campo nome é obrigatório")
  private String nome;

  @NotNull(message = "Campo agencia é obrigatório")
  @NotEmpty(message = "Campo agencia é obrigatório")
  private String agencia;

  @NotNull(message = "Campo conta é obrigatório")
  @NotEmpty(message = "Campo conta é obrigatório")
  private String conta;

  @NotNull(message = "Campo banco é obrigatório")
  @NotEmpty(message = "Campo banco é obrigatório")
  private String banco;

  private String gerente;
  private String observacao;
}
