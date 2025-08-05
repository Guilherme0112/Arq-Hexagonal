package com.hexagonal.demo.domain.pedido;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

  private Long id;
  private List<ItemPedido> itens;
  private StatusPedido status;
  private LocalDateTime dataCadastro;

  public Pedido() {}
  public Pedido(Long id, List<ItemPedido> itens, StatusPedido status) {
    this.id = id;
    this.itens = itens;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(LocalDateTime dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public List<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
  }

  public StatusPedido getStatus() {
    return status;
  }

  public void setStatus(StatusPedido status) {
    this.status = status;
  }
}
