package com.hexagonal.demo.adapters.outbound.entity;

import com.hexagonal.demo.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_Produto")
public class JpaProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "Preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "CodigoDeBarras", nullable = false)
    private String codigoDeBarras;

    @Column(name = "DataCadastro", nullable = false, updatable = false)
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
