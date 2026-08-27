package com.senai.rental.rental_eventos.controllers;

import com.senai.rental.rental_eventos.services.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental.rental_eventos.models.Categoria;
import com.senai.rental.rental_eventos.services.CategoriaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;
    @Autowired
    


    @GetMapping("/contar-categoria")
    public Long contarCategoria() {
        return categoriaService.contarCategorias();

    }

    @GetMapping("/buscar-categoria/{id}")
    public Categoria busCategoria (@PathVariable Integer id) {
        return categoriaService.buscarCategoria(id);
    }

    @GetMapping ("/listar-categoria")
    public List<Categoria> listaCategorias() {
        return categoriaService.listarCategorias();
    }

    @DeleteMapping("/deletar-categoria/{id}")
    public String deletarCategoria(@PathVariable Integer id) {
        if(categoriaService.deletarCategoria(id)) {
            return "Usuário removido com sucesso.";
        
        }
        return "Falha ao remover Usuário.";
    }

     @PostMapping("/salvar-categoria")
     public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.cadastrarCategoria(categoria);
     }

     @PutMapping("/atualizar-categoria/{id}")
     public String atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        if(categoriaService.atualizarCategoria(id, categoria) != null) {
            return "Categoria atualizada com sucesso.";

        }
        return "Falha ao remover categoria.";
     }
    
    
}
