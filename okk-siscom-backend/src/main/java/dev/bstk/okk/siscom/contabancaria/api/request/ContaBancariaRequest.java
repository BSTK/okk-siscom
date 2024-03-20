package dev.bstk.okk.siscom.contabancaria.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaBancariaRequest {

  @NotBlank(message = "Campo nome não pode ser nulo/vazio")
  private String nome;

  @NotBlank(message = "Campo agência não pode ser nulo/vazio")
  private String agencia;

  @NotBlank(message = "Campo conta não pode ser nulo/vazio")
  private String conta;

  @NotBlank(message = "Campo banco não pode ser nulo/vazio")
  private String banco;

  private String gerente;
  private String observacao;
}
