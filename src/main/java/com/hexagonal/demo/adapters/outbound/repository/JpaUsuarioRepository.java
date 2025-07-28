package com.hexagonal.demo.adapters.outbound.repository;

import com.hexagonal.demo.adapters.outbound.entity.JpaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUsuarioRepository extends JpaRepository<JpaUsuarioEntity, UUID> {
}
