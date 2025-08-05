package com.hexagonal.demo.adapters.outbound.mapper;

import com.hexagonal.demo.adapters.outbound.entity.JpaProdutoEntity;
import com.hexagonal.demo.domain.produto.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
  Produto toDomain(JpaProdutoEntity entity);
  JpaProdutoEntity toJpaEntity(Produto produto);
}

