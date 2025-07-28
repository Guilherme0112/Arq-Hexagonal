package com.hexagonal.demo.domain.usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Usuario findById(UUID id);
    List<Usuario> findAll();
    void deleteById(UUID id);
}
