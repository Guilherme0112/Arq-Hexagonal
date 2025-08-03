package com.hexagonal.demo.domain.produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto save(Produto produto);
    List<Produto> findAll();
    Optional<Produto> findById(Long id);
    void deleteById(Long id);
}
