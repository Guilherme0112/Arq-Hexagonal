package com.hexagonal.demo.adapters.inbound.controller;

import com.hexagonal.demo.application.dto.ResponseDTO;
import com.hexagonal.demo.application.usecases.PedidoUseCases;
import com.hexagonal.demo.domain.pedido.Pedido;
import com.hexagonal.demo.domain.produto.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

  private final PedidoUseCases pedidoUseCases;

  @GetMapping
  public List<Pedido> buscarPedidos() {
    return pedidoUseCases.listarPedidos();
  }

  @PostMapping
  public Pedido salvarPedido(@RequestBody Pedido pedido) throws Exception {
    return pedidoUseCases.salvarPedido(pedido);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<ResponseDTO> removerPedido(@PathVariable("id") Long id) {
    try {
      pedidoUseCases.removerPedido(id);
      return ResponseEntity.ok(new ResponseDTO(200, "Pedido removido com sucesso"));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(new ResponseDTO(400, "Pedido com o id " + id + " não encontrado"));
    }
  }
}
