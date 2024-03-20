package dev.bstk.okk.siscom.contabancaria.api;

import dev.bstk.okk.siscom.AppITestContainersConfig;
import dev.bstk.okk.siscom.AppTestUtil;
import dev.bstk.okk.siscom.contabancaria.api.request.ContaBancariaRequest;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okkutil.fixture.Fixture;
import dev.bstk.okkutil.json.jackson.Json;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContaBancariaResourceCadastrarNovaContaBancariaITest extends AppITestContainersConfig {

  @LocalServerPort
  private Integer portaHttp;

  @Autowired
  private ContaBancariaRepository contaBancariaRepository;

  @BeforeEach
  void setUpEach() {
    contaBancariaRepository.deleteAll();
  }

  @Test
  @DisplayName("Deve cadastrar uma nova conta bancária")
  void t1() {
    final var novaContaBancariaRequest = Fixture.fixure(
      "/fixture/contabancaria/nova-conta-bancaria-request.json",
      ContaBancariaRequest.class
    );

    final var response = executeRequestNovaContaBancaria(novaContaBancariaRequest);

    Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    Assertions.assertThat(response.jsonPath().getString("uuid")).isNotNull().isNotEmpty();
    Assertions.assertThat(response.jsonPath().getString("nome")).isEqualTo(novaContaBancariaRequest.getNome());
    Assertions.assertThat(response.jsonPath().getString("agencia")).isEqualTo(novaContaBancariaRequest.getAgencia());
    Assertions.assertThat(response.jsonPath().getString("conta")).isEqualTo(novaContaBancariaRequest.getConta());
    Assertions.assertThat(response.jsonPath().getString("gerente")).isEqualTo(novaContaBancariaRequest.getGerente());
    Assertions.assertThat(response.jsonPath().getString("banco")).isEqualTo(novaContaBancariaRequest.getBanco());
    Assertions.assertThat(response.jsonPath().getString("observacao")).isEqualTo(novaContaBancariaRequest.getObservacao());

    Assertions
      .assertThat(contaBancariaRepository.findAll())
      .hasSize(1);
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("Deve lançar exception ao tentar cadastrar uma conta sem \"nome\"")
  void t2(final String valor) {
    final var novaContaBancariaRequest = Fixture
      .fixure("/fixture/contabancaria/nova-conta-bancaria-request.json", ContaBancariaRequest.class);
    novaContaBancariaRequest.setNome(valor);

    executeCasosErrosDeValidacao(novaContaBancariaRequest, "nome");
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("Deve lançar exception ao tentar cadastrar uma conta sem \"agência\"")
  void t3(final String valor) {
    final var novaContaBancariaRequest = Fixture
      .fixure("/fixture/contabancaria/nova-conta-bancaria-request.json", ContaBancariaRequest.class);
    novaContaBancariaRequest.setAgencia(valor);

    executeCasosErrosDeValidacao(novaContaBancariaRequest, "agência");
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("Deve lançar exception ao tentar cadastrar uma conta sem \"conta\"")
  void t4(final String valor) {
    final var novaContaBancariaRequest = Fixture
      .fixure("/fixture/contabancaria/nova-conta-bancaria-request.json", ContaBancariaRequest.class);
    novaContaBancariaRequest.setConta(valor);

    executeCasosErrosDeValidacao(novaContaBancariaRequest, "conta");
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("Deve lançar exception ao tentar cadastrar uma conta sem \"banco\"")
  void t5(final String valor) {
    final var novaContaBancariaRequest = Fixture
      .fixure("/fixture/contabancaria/nova-conta-bancaria-request.json", ContaBancariaRequest.class);
    novaContaBancariaRequest.setBanco(valor);

    executeCasosErrosDeValidacao(novaContaBancariaRequest, "banco");
  }

  private Response executeRequestNovaContaBancaria(final ContaBancariaRequest request) {
    return RestAssured
      .given()
      .header("Content-Type", "application/json")
      .and()
      .body(Json.toString(request))
      .when()
      .post(AppTestUtil.url(portaHttp,"/v1/api/contas-bancarias"))
      .then()
      .extract()
      .response();
  }

  private void executeCasosErrosDeValidacao(final ContaBancariaRequest request, final String campo) {
    final var response = executeRequestNovaContaBancaria(request);

    Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    Assertions.assertThat(response.jsonPath().getString("dataHora")).isNotNull().isNotEmpty();
    Assertions.assertThat(response.jsonPath().getList("erros"))
      .contains(String.format("Campo %s não pode ser nulo/vazio", campo));

    Assertions
      .assertThat(contaBancariaRepository.findAll())
      .isEmpty();
  }
}
