package com.hexagonal.demo.application.usecases;

import com.hexagonal.demo.domain.usuario.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioUseCases {
    public Usuario salvarUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuario(UUID id);
    public void removerUsuario(UUID id);
}
