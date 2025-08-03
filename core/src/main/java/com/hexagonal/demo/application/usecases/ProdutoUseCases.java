package com.hexagonal.demo.application.usecases;

import com.hexagonal.demo.domain.produto.Produto;

import java.util.List;

public interface ProdutoUseCases {
    public Produto salvarProduto(Produto produto);
    public Produto buscarProduto(Long id);
    public List<Produto> listarProdutos();
    public void removerProduto(Long id) throws Exception;
}
