package com.hexagonal.demo.domain.pedido;

import com.hexagonal.demo.domain.produto.Produto;

public class ItemPedido {

  private Produto produto;
  private int quantidade;

  public ItemPedido() {}
  public ItemPedido(Produto produto, int quantidade) {
    this.quantidade = quantidade;
    this.produto = produto;
  }
  public int getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
  public Produto getProduto() {
    return produto;
  }
  public void setProduto(Produto produto) {
    this.produto = produto;
  }
}
