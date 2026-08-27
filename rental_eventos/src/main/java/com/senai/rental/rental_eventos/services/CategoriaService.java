package com.senai.rental.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.rental.rental_eventos.models.Categoria;
import com.senai.rental.rental_eventos.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository CategoriaRepository;

    public Long contarCategorias() {
        return CategoriaRepository.count();
    }

    public Categoria buscarCategoria(Integer id) {
        return CategoriaRepository.findById(id).get();
    }    

    public List<Categoria> listarCategorias() {
        return CategoriaRepository.findAll();
    }

    public Boolean deletarCategoria(Integer id) {
        if(CategoriaRepository.existsById(id)) {
            CategoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Categoria cadastrarCategoria(Categoria Categoria) {
        return CategoriaRepository.save(Categoria);

    }

    public Categoria atualizarCategoria(Integer id, Categoria Categoria) {
        Categoria CategoriaRecuperado = buscarCategoria(id);
        if(CategoriaRecuperado != null) {
            CategoriaRecuperado.setId(id);
            if(Categoria.getNome() != null) {
                CategoriaRecuperado.setNome(Categoria.getNome());
            }
           return CategoriaRepository.save(CategoriaRecuperado);
        } 
        return null;
       }
}
