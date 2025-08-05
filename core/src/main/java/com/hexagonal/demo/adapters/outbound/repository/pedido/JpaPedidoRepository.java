package com.hexagonal.demo.adapters.outbound.repository.pedido;

import com.hexagonal.demo.adapters.outbound.entity.JpaPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPedidoRepository extends JpaRepository<JpaPedidoEntity, Long> {
}
