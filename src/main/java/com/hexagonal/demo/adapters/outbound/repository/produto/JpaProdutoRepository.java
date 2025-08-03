package com.hexagonal.demo.adapters.outbound.repository.produto;

import com.hexagonal.demo.adapters.outbound.entity.JpaProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProdutoRepository extends JpaRepository<JpaProdutoEntity, Long> {
}
