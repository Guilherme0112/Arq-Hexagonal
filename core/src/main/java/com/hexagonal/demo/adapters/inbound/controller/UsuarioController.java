package com.hexagonal.demo.adapters.inbound.controller;

import com.hexagonal.demo.application.dto.ResponseDTO;
import com.hexagonal.demo.application.usecases.UsuarioUseCases;
import com.hexagonal.demo.domain.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> removerUsuario(@PathVariable("id") Long id) {
        try {
            usuarioUseCases.removerUsuario(id);
            return ResponseEntity.ok(new ResponseDTO(200, "Usuário removido com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(400, "Usuário com o id " + id + " não encontrado"));
        }
    }

}
