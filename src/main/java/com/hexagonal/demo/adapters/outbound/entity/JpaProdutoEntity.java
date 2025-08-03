package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.produto.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_Produto")
public class JpaProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String codigoDeBarras;
    private LocalDateTime dataCadastro;

    public JpaProdutoEntity(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.codigoDeBarras = produto.getCodigoDeBarras();
        this.dataCadastro = produto.getDataCadastro();
    }
}
