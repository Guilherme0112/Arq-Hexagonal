package com.hexagonal.demo.adapters.inbound.controller;

import com.hexagonal.demo.application.dto.ResponseDTO;
import com.hexagonal.demo.application.usecases.ProdutoUseCases;
import com.hexagonal.demo.domain.produto.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoUseCases produtoUseCases;

    @GetMapping
    public List<Produto> buscarProdutos() {
        return produtoUseCases.listarProdutos();
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoUseCases.salvarProduto(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> removerProduto(@PathVariable("id") Long id) {
        try {
            produtoUseCases.removerProduto(id);
            return ResponseEntity.ok(new ResponseDTO(200, "Produto removido com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(400, "Produto com o id " + id + " não encontrado"));
        }
    }
}
