package dev.bstk.okk.siscom.contabancaria.api;

import dev.bstk.okk.siscom.contabancaria.api.request.ContaBancariaRequest;
import dev.bstk.okk.siscom.contabancaria.api.response.ContaBancariaResponse;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancaria;
import dev.bstk.okk.siscom.contabancaria.domain.ContaBancariaRepository;
import dev.bstk.okk.siscom.contabancaria.service.ContaBancariaService;
import dev.bstk.okkutil.mapper.modelmapper.Mapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/contas-bancarias")
public class ContaBancariaResource {

  private final ContaBancariaService contaBancariaService;
  private final ContaBancariaRepository contaBancariaRepository;


  @PostMapping
  public ResponseEntity<ContaBancariaResponse> novaContaBancaria(@RequestBody @Valid final ContaBancariaRequest request) {
    final var contaBancaria = Mapper.to(request, ContaBancaria.class);
    final var contaBancariaCadastrada = contaBancariaService.novaContaBancaria(contaBancaria);
    final var contaBancariaCadastradaResponse = Mapper.to(contaBancariaCadastrada, ContaBancariaResponse.class);

    return ResponseEntity.status(HttpStatus.CREATED).body(contaBancariaCadastradaResponse);
  }

  @GetMapping
  public ResponseEntity<List<ContaBancariaResponse>> contasBancarias() {
    final var contasBancariasCadastradas = contaBancariaRepository.findAll();
    final var contasBancariasCadastradasResponse = Mapper.list(contasBancariasCadastradas, ContaBancariaResponse.class);

    return ResponseEntity.ok(contasBancariasCadastradasResponse);
  }
}
