package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.pedido.ItemPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_ItemPedido")
@AllArgsConstructor
@NoArgsConstructor
public class JpaItemPedidoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private JpaProdutoEntity produto;
  private int quantidade;

  public JpaItemPedidoEntity(ItemPedido item) {
    this.produto = new JpaProdutoEntity(item.getProduto());
    this.quantidade = item.getQuantidade();
  }
}
