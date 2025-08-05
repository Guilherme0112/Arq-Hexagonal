package com.hexagonal.demo.application.usecases;

import com.hexagonal.demo.domain.pedido.Pedido;

import java.util.List;

public interface PedidoUseCases {
  public Pedido salvarPedido(Pedido pedido) throws Exception;
  public List<Pedido> listarPedidos();
  public Pedido buscarPedido(Long id);
  public void removerPedido(Long id) throws Exception;
}
