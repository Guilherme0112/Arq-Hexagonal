package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JpaUsuarioEntity {

    private UUID id;
    private String nome;
    private String email;
    private String senha;

    public JpaUsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }


}
