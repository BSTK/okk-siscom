package dev.bstk.okk.siscom.contabancaria.api;

import dev.bstk.okk.siscom.contabancaria.api.request.ContaBancariaRequest;
import dev.bstk.okk.siscom.contabancaria.api.response.ContaBancariaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/api/contas-bancarias")
public class ContaBancariaResource {


  @PostMapping
  public ResponseEntity<ContaBancariaResponse> novaContaBancaria(@RequestBody final ContaBancariaRequest request) {
    log.info("Cadastrando uma nova conta bancária");

    final var response = ContaBancariaResponse.builder()
      .id(UUID.randomUUID())
      .nome("Conta Santander")
      .conta("09991")
      .agencia("099-00")
      .gerente("Antonio Garcia")
      .observacao("Conta geral")
      .build();

    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<ContaBancariaResponse>> contasBancarias() {
    final var response = List.of(
      ContaBancariaResponse.builder()
        .id(UUID.randomUUID())
        .nome("Conta Santander")
        .conta("09991")
        .agencia("099-00")
        .gerente("Antonio Garcia")
        .observacao("Conta geral")
        .build(),

      ContaBancariaResponse.builder()
        .id(UUID.randomUUID())
        .nome("Conta Bradesco")
        .conta("098881")
        .agencia("888-00")
        .gerente("Maria do Carmo")
        .observacao("Conta geral II")
        .build()
    );

    return ResponseEntity.ok(response);
  }
}
