package dev.bstk.okk.siscom.contabancaria.service;

import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
