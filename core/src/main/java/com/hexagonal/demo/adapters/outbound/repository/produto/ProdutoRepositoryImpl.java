package com.hexagonal.demo.adapters.outbound.repository.produto;

import com.hexagonal.demo.adapters.outbound.entity.JpaProdutoEntity;
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

  @Override
  public Produto save(Produto produto) {
    JpaProdutoEntity jpaProdutoEntity = new JpaProdutoEntity(produto);
    JpaProdutoEntity produtoSalvo = this.jpaProdutoRepository.save(jpaProdutoEntity);
    return new Produto(produtoSalvo.getId(),
            produtoSalvo.getNome(),
            produtoSalvo.getDescricao(),
            produtoSalvo.getCodigoDeBarras(),
            produtoSalvo.getPreco(),
            produtoSalvo.getDataCadastro());
  }

  @Override
  public List<Produto> findAll(){
    List<JpaProdutoEntity> jpaProdutoEntity = this.jpaProdutoRepository.findAll();
    return jpaProdutoEntity.stream().map(jpaProduto ->
      new Produto(
        jpaProduto.getId(),
        jpaProduto.getNome(),
        jpaProduto.getDescricao(),
        jpaProduto.getCodigoDeBarras(),
        jpaProduto.getPreco(),
        jpaProduto.getDataCadastro()
      )
    ).toList();
  }

  @Override
  public Optional<Produto> findById(Long id){
    Optional<JpaProdutoEntity> jpaProdutoEntity = this.jpaProdutoRepository.findById(id);
    return jpaProdutoEntity.map(jpaProduto ->
      new Produto(
          jpaProduto.getId(),
          jpaProduto.getNome(),
          jpaProduto.getDescricao(),
          jpaProduto.getCodigoDeBarras(),
          jpaProduto.getPreco(),
          jpaProduto.getDataCadastro()
      )
    );
  }

  @Override
  public void deleteById(Long id){
    this.jpaProdutoRepository.deleteById(id);
  }
}
