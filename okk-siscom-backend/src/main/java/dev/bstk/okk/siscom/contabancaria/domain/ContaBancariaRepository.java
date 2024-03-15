package dev.bstk.okk.siscom.contabancaria.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

  @Query(value = """
    SELECT CASE WHEN COUNT(b.ID) > 0 THEN 'TRUE' ELSE 'FALSE' END
    FROM BANCO b
    WHERE b.agencia = :agencia
    AND   b.conta   = :conta
    AND   b.banco   = :banco
    """, nativeQuery = true)
  boolean existeContaBancariaCadastrada(
    @Param("agencia") final String agencia,
    @Param("conta") final String conta,
    @Param("banco") final String banco
  );

}
