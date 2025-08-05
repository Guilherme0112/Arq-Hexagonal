package com.hexagonal.demo.adapters.outbound.mapper;

import com.hexagonal.demo.adapters.outbound.entity.JpaUsuarioEntity;
import com.hexagonal.demo.domain.usuario.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
  Usuario toDomain(JpaUsuarioEntity jpaUsuarioEntity);
  JpaUsuarioEntity toJpaDomain(Usuario usuario);
}
