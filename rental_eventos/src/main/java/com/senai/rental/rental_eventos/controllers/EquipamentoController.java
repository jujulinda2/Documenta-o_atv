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

import com.senai.rental.rental_eventos.models.Equipamento;
import com.senai.rental.rental_eventos.services.EquipamentoService;


@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;
    
    

    @GetMapping("/contar-equipamento")
    public Long contarEquipamentos() {
        return equipamentoService.contarEquipamentos();

    }

    @GetMapping("/buscar-equipamento/{id}")
    public Equipamento busEquipamento (@PathVariable Integer id) {
        return equipamentoService.buscarEquipamento(id);
    }

    @GetMapping ("/listar-equipamento")
    public List<Equipamento> listaEquipamentos() {
        return equipamentoService.listarEquipamentos();
    }

    @DeleteMapping("/deletar-equipamento/{id}")
    public String deletarEquipamento(@PathVariable Integer id) {
        if(equipamentoService.deletarEquipamento(id)) {
            return "Usuário removido com sucesso.";
        
        }
        return "Falha ao remover Usuário.";
    }

     @PostMapping("/salvar-equipamento")
     public Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
     }

     @PutMapping("/atualizar-equipamento/{id}")
     public String atualizarEquipamento(@PathVariable Integer id, @RequestBody Equipamento equipamento) {
        if(equipamentoService.atualizarEquipamento(id, equipamento) != null) {
            return "Equipamento atualizada com sucesso.";

        }
        return "Falha ao remover equipamento.";
     }
    
 
}
