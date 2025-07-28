package com.hexagonal.demo.application.service;

import com.hexagonal.demo.application.usecases.UsuarioUseCases;
import com.hexagonal.demo.domain.usuario.Usuario;
import com.hexagonal.demo.domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public void removerUsuario(Long id) throws Exception {
        Usuario user = usuarioRepository.findById(id);
        if(user == null) throw new Exception("Usuario com o id "+ id +" não encontrado");
        usuarioRepository.deleteById(id);
    }
}
