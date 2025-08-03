package com.hexagonal.demo.domain.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String codigoDeBarras;
    private LocalDateTime dataCadastro;

    public Produto() {}
    public Produto(Long id, String nome, String codigoDeBarras, String descricao, BigDecimal preco, LocalDateTime dataCadastro) {
        this.id = id;
        this.codigoDeBarras = codigoDeBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoDeBarras(){
        return codigoDeBarras;
    }
    public void setCodigoDeBarras(String codigoDeBarras){
        this.codigoDeBarras = codigoDeBarras;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
