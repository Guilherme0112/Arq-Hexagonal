package com.hexagonal.demo.application.usecases;

import com.hexagonal.demo.domain.usuario.Usuario;

import java.util.List;

public interface UsuarioUseCases {
    public Usuario salvarUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuario(Long id);
    public void removerUsuario(Long id) throws Exception;
}
