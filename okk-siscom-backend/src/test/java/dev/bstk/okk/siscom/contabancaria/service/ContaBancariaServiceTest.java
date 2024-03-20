package dev.bstk.okk.siscom.contabancaria.service;

import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okk.siscom.core.handlerexception.exception.RecursoNaoEncontradoException;
import dev.bstk.okkutil.fixture.Fixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;
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
    final var contaBancaria = Fixture.fixure("/fixture/contabancaria/nova-conta-bancaria.json", ContaBancaria.class);
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

  @Test
  @DisplayName("Deve lançar exception quando tentar cadastrar uma conta que já existe")
  void t2() {
    final var contaBancaria = Fixture.fixure("/fixture/contabancaria/nova-conta-bancaria.json", ContaBancaria.class);
    Mockito.when(contaBancariaRepository.existeContaBancariaCadastrada(
      contaBancaria.getAgencia(),
      contaBancaria.getConta(),
      contaBancaria.getBanco()
    )).thenReturn(true);

    Assertions
      .assertThatThrownBy(() -> contaBancariaService.novaContaBancaria(contaBancaria))
      .isExactlyInstanceOf(IllegalArgumentException.class)
      .hasMessage("Conta já cadastrada!");

    Mockito.verifyNoMoreInteractions(contaBancariaRepository);
  }

  @Test
  @DisplayName("Deve atualizar dados de um conta bancária já existente")
  void t3() {
    final var uuidAtualizar = UUID.randomUUID();
    final var contaBancariaJaCadastrada = Fixture.fixure("/fixture/contabancaria/nova-conta-bancaria.json", ContaBancaria.class);
    final var contaBancariaParaAtualizar = Fixture.fixure("/fixture/contabancaria/conta-bancaria-atualizar.json", ContaBancaria.class);

    Mockito
      .when(contaBancariaRepository.buscarPorUuid(uuidAtualizar))
      .thenReturn(Optional.of(contaBancariaJaCadastrada));

    Mockito
      .when(contaBancariaRepository.saveAndFlush(contaBancariaJaCadastrada))
      .thenAnswer(mock -> {
        final var contaBancariaAtualizada = (ContaBancaria) mock.getArguments()[0];
        contaBancariaAtualizada.setId(contaBancariaJaCadastrada.getId());
        contaBancariaAtualizada.setUuid(contaBancariaJaCadastrada.getUuid());
        contaBancariaAtualizada.setDataUpdate(Instant.now());

        return contaBancariaAtualizada;
      });

    final var resultado = contaBancariaService.atualizarContaBancaria(
      uuidAtualizar,
      contaBancariaParaAtualizar
    );

    Assertions.assertThat(resultado).isNotNull();
    Assertions.assertThat(resultado.getId()).isNotNull();
    Assertions.assertThat(resultado.getUuid()).isNotNull();

    Assertions.assertThat(resultado.getNome()).isEqualTo(contaBancariaParaAtualizar.getNome());
    Assertions.assertThat(resultado.getAgencia()).isEqualTo(contaBancariaParaAtualizar.getAgencia());
    Assertions.assertThat(resultado.getConta()).isEqualTo(contaBancariaParaAtualizar.getConta());
    Assertions.assertThat(resultado.getBanco()).isEqualTo(contaBancariaParaAtualizar.getBanco());
    Assertions.assertThat(resultado.getGerente()).isEqualTo(contaBancariaParaAtualizar.getGerente());
    Assertions.assertThat(resultado.getObservacao()).isEqualTo(contaBancariaParaAtualizar.getObservacao());

    Mockito.verify(contaBancariaRepository).buscarPorUuid(uuidAtualizar);
    Mockito.verify(contaBancariaRepository).saveAndFlush(contaBancariaJaCadastrada);
  }

  @Test
  @DisplayName("Deve lançar exception quando tentar atualizar uma conta que não existe")
  void t4() {
    final var uuidAtualizar = UUID.randomUUID();
    final var contaBancariaParaAtualizar = Fixture.fixure("/fixture/contabancaria/conta-bancaria-atualizar.json", ContaBancaria.class);

    Mockito
      .when(contaBancariaRepository.buscarPorUuid(uuidAtualizar))
      .thenReturn(Optional.empty());

    Assertions
      .assertThatThrownBy(() -> contaBancariaService.atualizarContaBancaria(
        uuidAtualizar,
        contaBancariaParaAtualizar
      ))
      .isExactlyInstanceOf(RecursoNaoEncontradoException.class)
      .hasMessage("Não existe conta cadastrada!");

    Mockito.verifyNoMoreInteractions(contaBancariaRepository);
  }
}
