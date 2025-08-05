package com.hexagonal.demo.adapters.outbound.mapper;

import com.hexagonal.demo.adapters.outbound.entity.JpaPedidoEntity;
import com.hexagonal.demo.domain.pedido.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ItemPedidoMapper.class})
public interface PedidoMapper {
  Pedido toDomain(JpaPedidoEntity jpaPedidoEntity);
  JpaPedidoEntity toJpaEntity(Pedido pedido);
}

