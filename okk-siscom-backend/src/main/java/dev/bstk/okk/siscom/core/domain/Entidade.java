package dev.bstk.okk.siscom.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class Entidade {

  @CreationTimestamp
  @Column(name = "DATA_INSERT")
  protected Instant dataInsert;

  @UpdateTimestamp
  @Column(name = "DATA_UPDATE")
  protected Instant dataUpdate;
}
