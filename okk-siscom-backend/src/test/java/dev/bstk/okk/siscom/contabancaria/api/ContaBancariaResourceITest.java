package dev.bstk.okk.siscom.contabancaria.api;

import dev.bstk.okk.siscom.AppITestContainersConfig;
import dev.bstk.okk.siscom.contabancaria.api.request.ContaBancariaRequest;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okkutil.fixture.Fixture;
import dev.bstk.okkutil.json.jackson.Json;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContaBancariaResourceITest extends AppITestContainersConfig {

  @LocalServerPort
  private Integer portaHttp;

  @Autowired
  private ContaBancariaRepository contaBancariaRepository;


  @Test
  @DisplayName("Deve cadastrar uma nova conta bancária")
  void t1() {
    final var novaContaBancariaRequest = Fixture.fixure(
      "/fixture/contabancaria/nova-conta-bancaria-request.json",
      ContaBancariaRequest.class
    );

    final var response = RestAssured
      .given()
      .header("Content-Type", "application/json")
      .and()
      .body(Json.toString(novaContaBancariaRequest))
      .when()
      .post(String.format("http://localhost:%s/v1/api/contas-bancarias", portaHttp))
      .then()
      .extract()
      .response();

    Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    Assertions.assertThat(response.jsonPath().getString("uuid")).isNotNull().isNotEmpty();
    Assertions.assertThat(response.jsonPath().getString("nome")).isEqualTo(novaContaBancariaRequest.nome());
    Assertions.assertThat(response.jsonPath().getString("agencia")).isEqualTo(novaContaBancariaRequest.agencia());
    Assertions.assertThat(response.jsonPath().getString("conta")).isEqualTo(novaContaBancariaRequest.conta());
    Assertions.assertThat(response.jsonPath().getString("gerente")).isEqualTo(novaContaBancariaRequest.gerente());
    Assertions.assertThat(response.jsonPath().getString("banco")).isEqualTo(novaContaBancariaRequest.banco());
    Assertions.assertThat(response.jsonPath().getString("observacao")).isEqualTo(novaContaBancariaRequest.observacao());

    Assertions
      .assertThat(contaBancariaRepository.findAll())
      .hasSize(1);
  }
}
