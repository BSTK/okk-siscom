package dev.bstk.okk.siscom.contabancaria.service;

import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okk.siscom.core.handlerexception.exception.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContaBancariaService {

  private final ContaBancariaRepository contaBancariaRepository;

  public ContaBancaria novaContaBancaria(final ContaBancaria contaBancaria) {
    final var existeContaBancariaCadastrada = contaBancariaRepository.existeContaBancariaCadastrada(
      contaBancaria.getAgencia(),
      contaBancaria.getConta(),
      contaBancaria.getBanco()
    );

    if (existeContaBancariaCadastrada) {
      throw new IllegalArgumentException("Conta já cadastrada!");
    }

    return contaBancariaRepository.saveAndFlush(contaBancaria);
  }

  public ContaBancaria atualizarContaBancaria(final UUID uuid,
                                              final ContaBancaria contaBancaria) {
    final var contaBancariaAtualizar = contaBancariaRepository
      .buscarPorUuid(uuid)
      .orElseThrow(() -> {
        log.warn("Não existe conta cadastrada para uuid [ {} ]", uuid);
        return new RecursoNaoEncontradoException(
          String.format("Não existe conta cadastrada para uuid [ %s ]", uuid)
        );
      });

    contaBancariaAtualizar.setNome(contaBancaria.getNome());
    contaBancariaAtualizar.setAgencia(contaBancaria.getAgencia());
    contaBancariaAtualizar.setConta(contaBancaria.getConta());
    contaBancariaAtualizar.setBanco(contaBancaria.getBanco());
    contaBancariaAtualizar.setGerente(contaBancaria.getGerente());
    contaBancariaAtualizar.setObservacao(contaBancaria.getObservacao());

    return contaBancariaRepository.saveAndFlush(contaBancariaAtualizar);
  }

}
