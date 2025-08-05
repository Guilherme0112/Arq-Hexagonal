package com.hexagonal.demo.application.service;

import com.hexagonal.demo.application.usecases.ProdutoUseCases;
import com.hexagonal.demo.domain.produto.Produto;
import com.hexagonal.demo.domain.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoUseCases {

    private final ProdutoRepository produtoRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Produto salvarProduto(Produto produto) {
        produto.setDataCadastro(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return produtoRepository.save(produto);
    }

    public Produto buscarProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public List<Produto> listarProdutos() {
        kafkaTemplate.send("produto-salvo-topic", "teste de mensagem");
        return produtoRepository.findAll();
    }

    public void removerProduto(Long id) throws Exception{
        produtoRepository.findById(id)
                .orElseThrow(() -> new Exception("Produto com o id "+ id +" não encontrado"));
        produtoRepository.deleteById(id);
    }
}
