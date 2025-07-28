package com.hexagonal.demo.application.service;

import com.hexagonal.demo.application.usecases.UsuarioUseCases;
import com.hexagonal.demo.domain.usuario.Usuario;
import com.hexagonal.demo.domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioUseCases {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(UUID id){
        return usuarioRepository.findById(id);
    }


    public void removerUsuario(UUID id){
        usuarioRepository.deleteById(id);
    }
}
