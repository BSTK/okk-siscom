package unit.dev.bstk.okk.siscom.contabancaria.service;

import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okk.siscom.contabancaria.service.ContaBancariaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ContaBancariaServiceTest {

  private static final Random RANDOM = new Random();

  @InjectMocks
  private ContaBancariaService contaBancariaService;

  @Mock
  private ContaBancariaRepository contaBancariaRepository;

  @Test
  @DisplayName("Deve cadastrar uma nova conta")
  void t1() {
    final var contaBancaria = ContaBancaria
      .builder()
      .nome("Conta Bradesco")
      .agencia("123")
      .conta("1234-5")
      .banco("381")
      .gerente("Antonio Alves")
      .observacao("Conta Matéria Prima")
      .build();

    Mockito.when(contaBancariaRepository.existeContaBancariaCadastrada(
      contaBancaria.getAgencia(),
      contaBancaria.getConta(),
      contaBancaria.getBanco()
    )).thenReturn(false);

    Mockito
      .when(contaBancariaRepository.saveAndFlush(contaBancaria))
      .thenAnswer(mock -> {
        final var contaBancariaSalva = (ContaBancaria) mock.getArguments()[0];
        contaBancariaSalva.setId(RANDOM.nextLong());
        contaBancariaSalva.setUuid(UUID.randomUUID());
        contaBancariaSalva.setDataInsert(Instant.now());
        contaBancariaSalva.setDataUpdate(Instant.now());

        return contaBancariaSalva;
      });

    final ContaBancaria resultado = contaBancariaService.novaContaBancaria(contaBancaria);

    Mockito.verify(contaBancariaRepository, Mockito.times(1)).existeContaBancariaCadastrada(
      contaBancaria.getAgencia(),
      contaBancaria.getConta(),
      contaBancaria.getBanco()
    );

    Mockito.verify(contaBancariaRepository).saveAndFlush(contaBancaria);

    Assertions.assertThat(resultado).isNotNull();
    Assertions.assertThat(resultado.getId()).isNotNull();
    Assertions.assertThat(resultado.getUuid()).isNotNull();

    Assertions.assertThat(resultado.getNome()).isEqualTo(contaBancaria.getNome());
    Assertions.assertThat(resultado.getAgencia()).isEqualTo(contaBancaria.getAgencia());
    Assertions.assertThat(resultado.getConta()).isEqualTo(contaBancaria.getConta());
    Assertions.assertThat(resultado.getBanco()).isEqualTo(contaBancaria.getBanco());
    Assertions.assertThat(resultado.getGerente()).isEqualTo(contaBancaria.getGerente());
    Assertions.assertThat(resultado.getObservacao()).isEqualTo(contaBancaria.getObservacao());

    Assertions.assertThat(resultado.getDataInsert()).isNotNull();
    Assertions.assertThat(resultado.getDataUpdate()).isNotNull();
  }

}
