package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tb_Usuario")
public class JpaUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Senha", nullable = false)
    private String senha;

    @Column(name = "DataCadastro", nullable = false)
    private LocalDateTime dataCadastro;

    public JpaUsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.dataCadastro = usuario.getDataCadastro();
    }


}
