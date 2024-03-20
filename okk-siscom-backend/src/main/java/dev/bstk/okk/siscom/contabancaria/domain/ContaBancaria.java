package dev.bstk.okk.siscom.contabancaria.domain;

import dev.bstk.okk.siscom.core.domain.Entidade;
import dev.bstk.okk.siscom.core.domain.UUIDConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BANCO")
public class ContaBancaria extends Entidade {

  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "SEQUENCE_BANCO"
  )
  @SequenceGenerator(name = "SEQUENCE_BANCO", allocationSize = 1)
  private Long id;

  @NotNull
  @Convert(converter = UUIDConverter.class)
  @Column(name = "UUID")
  private UUID uuid;

  @NotNull
  @NotEmpty
  @Column(name = "NOME")
  private String nome;

  @NotNull
  @NotEmpty
  @Column(name = "AGENCIA")
  private String agencia;

  @NotNull
  @NotEmpty
  @Column(name = "CONTA")
  private String conta;

  @NotNull
  @NotEmpty
  @Column(name = "BANCO")
  private String banco;

  @Column(name = "GERENTE")
  private String gerente;

  @Column(name = "OBSERVACAO")
  private String observacao;

  @PrePersist
  private void prePersist() {
    setUuid(UUID.randomUUID());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContaBancaria that = (ContaBancaria) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}