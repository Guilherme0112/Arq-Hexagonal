package com.hexagonal.demo.application.service;

import com.hexagonal.demo.application.usecases.PedidoUseCases;
import com.hexagonal.demo.domain.pedido.ItemPedido;
import com.hexagonal.demo.domain.pedido.Pedido;
import com.hexagonal.demo.domain.pedido.PedidoRepository;
import com.hexagonal.demo.domain.produto.Produto;
import com.hexagonal.demo.domain.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoUseCases {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Pedido salvarPedido(Pedido pedido) throws Exception {
        List<ItemPedido> itens = new ArrayList<>();

        for (ItemPedido item : pedido.getItens()) {
            Produto produtoBanco = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new Exception("Produto com o id " + item.getProduto().getId() + " não encontrado"));

            item.setProduto(produtoBanco);
            itens.add(item);
        }

        pedido.setItens(itens);
        pedido.setDataCadastro(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        kafkaTemplate.send("pedido-salvo-topic", "é isso aí carai");

        return pedidoSalvo;
    }

  public List<Pedido> listarPedidos(){
    return pedidoRepository.findAll();
  }
  public Pedido buscarPedido(Long id){
    return pedidoRepository.findById(id).orElse(null);
  }
  public void removerPedido(Long id) throws Exception {
    pedidoRepository.findById(id)
                    .orElseThrow(() -> new Exception("Pedido com o id "+ id +" não encontrado"));
    pedidoRepository.deleteById(id);
  }
}
