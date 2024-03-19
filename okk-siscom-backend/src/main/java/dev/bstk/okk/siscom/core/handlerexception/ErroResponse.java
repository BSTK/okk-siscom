package dev.bstk.okk.siscom.core.handlerexception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErroResponse {

  @JsonProperty("erros")
  private final List<String> erros;

  @JsonProperty("dataHora")
  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private final LocalDateTime dataHora;

  public ErroResponse(final List<String> erros) {
    this.erros = erros;
    this.dataHora = LocalDateTime.now();
  }

  public ErroResponse(final String erro) {
    this.erros = List.of(erro);
    this.dataHora = LocalDateTime.now();
  }
}
