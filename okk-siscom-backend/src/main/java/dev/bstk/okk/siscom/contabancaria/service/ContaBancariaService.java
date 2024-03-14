package dev.bstk.okk.siscom.contabancaria.service;

import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContaBancariaService {

  private final ContaBancariaRepository contaBancariaRepository;

  private ContaBancaria novaContaBancaria(final ContaBancaria contaBancaria) {
    return null;
  }
}
