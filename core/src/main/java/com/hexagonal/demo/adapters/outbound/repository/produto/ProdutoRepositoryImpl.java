package com.hexagonal.demo.adapters.outbound.repository.produto;

import com.hexagonal.demo.adapters.outbound.entity.JpaProdutoEntity;
import com.hexagonal.demo.adapters.outbound.mapper.ProdutoMapper;
import com.hexagonal.demo.domain.produto.Produto;
import com.hexagonal.demo.domain.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

  private final JpaProdutoRepository jpaProdutoRepository;
  private final ProdutoMapper produtoMapper;

  @Override
  public Produto save(Produto produto) {
    JpaProdutoEntity jpaProdutoEntity = new JpaProdutoEntity(produto);
    JpaProdutoEntity produtoSalvo = this.jpaProdutoRepository.save(jpaProdutoEntity);
    return produtoMapper.toDomain(produtoSalvo);
  }

  @Override
  public List<Produto> findAll(){
    List<JpaProdutoEntity> jpaProdutoEntity = this.jpaProdutoRepository.findAll();
    return jpaProdutoEntity
            .stream()
            .map(produtoMapper::toDomain)
            .toList();
  }

  @Override
  public Optional<Produto> findById(Long id){
    Optional<JpaProdutoEntity> jpaProdutoEntity = this.jpaProdutoRepository.findById(id);
    return jpaProdutoEntity
            .map(produtoMapper::toDomain);
  }

  @Override
  public void deleteById(Long id){
    this.jpaProdutoRepository.deleteById(id);
  }
}
