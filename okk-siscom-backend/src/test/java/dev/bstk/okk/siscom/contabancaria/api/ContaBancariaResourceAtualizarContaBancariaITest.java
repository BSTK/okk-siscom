package dev.bstk.okk.siscom.contabancaria.api;

import dev.bstk.okk.siscom.AppITestContainersConfig;
import dev.bstk.okk.siscom.AppTestUtil;
import dev.bstk.okk.siscom.contabancaria.api.request.ContaBancariaRequest;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okkutil.fixture.Fixture;
import dev.bstk.okkutil.json.jackson.Json;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContaBancariaResourceAtualizarContaBancariaITest extends AppITestContainersConfig {

  @LocalServerPort
  private Integer portaHttp;

  @Autowired
  private ContaBancariaRepository contaBancariaRepository;

  @BeforeEach
  void setUpEach() {
    contaBancariaRepository.deleteAll();
  }

  @Test
  @DisplayName("Deve atualizar dados de um conta bancária já existente")
  void t1() {
    final var contaBancariaMassadados = Fixture.fixure("/fixture/contabancaria/nova-conta-bancaria.json", ContaBancaria.class);
    final var contaBancariaJaCadastrada = contaBancariaRepository.saveAndFlush(contaBancariaMassadados);

    final var urlAtualizarConta = String.format("/v1/api/contas-bancarias/%s", contaBancariaJaCadastrada.getUuid());
    final var contaBancariaParaAtualizarRequest = Fixture.fixure("/fixture/contabancaria/conta-bancaria-atualizar.json", ContaBancariaRequest.class);

    final var response = RestAssured
      .given()
      .header("Content-Type", "application/json")
      .and()
      .body(Json.toString(contaBancariaParaAtualizarRequest))
      .when()
      .put(AppTestUtil.url(portaHttp, urlAtualizarConta))
      .then()
      .extract()
      .response();

    Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    Assertions.assertThat(response.jsonPath().getString("uuid")).isNotNull().isNotEmpty();
    Assertions.assertThat(response.jsonPath().getString("nome")).isEqualTo(contaBancariaParaAtualizarRequest.getNome());
    Assertions.assertThat(response.jsonPath().getString("agencia")).isEqualTo(contaBancariaParaAtualizarRequest.getAgencia());
    Assertions.assertThat(response.jsonPath().getString("conta")).isEqualTo(contaBancariaParaAtualizarRequest.getConta());
    Assertions.assertThat(response.jsonPath().getString("gerente")).isEqualTo(contaBancariaParaAtualizarRequest.getGerente());
    Assertions.assertThat(response.jsonPath().getString("banco")).isEqualTo(contaBancariaParaAtualizarRequest.getBanco());
    Assertions.assertThat(response.jsonPath().getString("observacao")).isEqualTo(contaBancariaParaAtualizarRequest.getObservacao());

    Assertions
      .assertThat(contaBancariaRepository.findAll())
      .hasSize(1);

    contaBancariaRepository
      .buscarPorUuid(contaBancariaJaCadastrada.getUuid())
      .ifPresent(resultado -> {
        Assertions.assertThat(contaBancariaParaAtualizarRequest.getNome()).isEqualTo(resultado.getNome());
        Assertions.assertThat(contaBancariaParaAtualizarRequest.getAgencia()).isEqualTo(resultado.getAgencia());
        Assertions.assertThat(contaBancariaParaAtualizarRequest.getConta()).isEqualTo(resultado.getConta());
        Assertions.assertThat(contaBancariaParaAtualizarRequest.getBanco()).isEqualTo(resultado.getBanco());
        Assertions.assertThat(contaBancariaParaAtualizarRequest.getGerente()).isEqualTo(resultado.getGerente());
        Assertions.assertThat(contaBancariaParaAtualizarRequest.getObservacao()).isEqualTo(resultado.getObservacao());
      });
  }
}
