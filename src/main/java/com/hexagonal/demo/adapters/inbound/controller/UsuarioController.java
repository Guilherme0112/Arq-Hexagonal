package com.hexagonal.demo.adapters.inbound.controller;

import com.hexagonal.demo.application.usecases.UsuarioUseCases;
import com.hexagonal.demo.domain.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCases usuarioUseCases;

    @GetMapping
    public List<Usuario> buscarUsuarios(){
        return usuarioUseCases.listarUsuarios();
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioUseCases.salvarUsuario(usuario);
    }
}
