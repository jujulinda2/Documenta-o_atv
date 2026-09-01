package com.senai.rental.rental_eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental.rental_eventos.models.Movimentacao;
import com.senai.rental.rental_eventos.services.MovimentacaoService;


@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;
    
    

    @GetMapping("/contar-movimentacao")
    public Long contarMovimentacaos() {
        return movimentacaoService.contarMovimentacaos();

    }

    @GetMapping("/buscar-movimentacao/{id}")
    public Movimentacao busMovimentacao (@PathVariable Integer id) {
        return movimentacaoService.buscarMovimentacao(id);
    }

    @GetMapping ("/listar-movimentacao")
    public List<Movimentacao> listaMovimentacaos() {
        return movimentacaoService.listarMovimentacaos();
    }

    @DeleteMapping("/deletar-movimentacao/{id}")
    public String deletarMovimentacao(@PathVariable Integer id) {
        if(movimentacaoService.deletarMovimentacao(id)) {
            return "Usuário removido com sucesso.";
        
        }
        return "Falha ao remover Usuário.";
    }

     @PostMapping("/salvar-movimentacao")
     public Movimentacao cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.cadastrarMovimentacao(movimentacao);
     }

     @PutMapping("/atualizar-movimentacao/{id}")
     public String atualizarMovimentacao(@PathVariable Integer id, @RequestBody Movimentacao movimentacao) {
        if(movimentacaoService.atualizarMovimentacao(id, movimentacao) != null) {
            return "Movimentacao atualizada com sucesso.";

        }
        return "Falha ao remover movimentacao.";
     }
    
    
}
