package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.pedido.Pedido;
import com.hexagonal.demo.domain.pedido.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Getter
@Setter
@Entity(name = "TB_Pedido")
@AllArgsConstructor
@NoArgsConstructor
public class JpaPedidoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "Id_Pedido")
  private List<JpaItemPedidoEntity> itens;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  @Column(name = "DataCadastro", nullable = false, updatable = false)
  private LocalDateTime dataCadastro;

  public JpaPedidoEntity(Pedido pedido) {
    this.id = pedido.getId();
    this.status = pedido.getStatus();
    if (pedido.getItens() != null) {
      this.itens = pedido.getItens().stream()
              .map(JpaItemPedidoEntity::new)
              .toList();
    }
    this.dataCadastro = pedido.getDataCadastro();
  }
}
