package com.hexagonal.demo.adapters.outbound.mapper;

import com.hexagonal.demo.adapters.outbound.entity.JpaItemPedidoEntity;
import com.hexagonal.demo.domain.pedido.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProdutoMapper.class})
public interface ItemPedidoMapper {
  ItemPedido toDomain(JpaItemPedidoEntity entity);
  JpaItemPedidoEntity toJpaEntity(ItemPedido item);
}

