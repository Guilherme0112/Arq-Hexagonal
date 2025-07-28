package com.hexagonal.demo.adapters.outbound.repository;

import com.hexagonal.demo.adapters.outbound.entity.JpaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuarioRepository extends JpaRepository<JpaUsuarioEntity, Long> {
}
