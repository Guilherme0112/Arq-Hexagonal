package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tb_Usuario")
public class JpaUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;

    public JpaUsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.dataCadastro = usuario.getDataCadastro();
    }


}
