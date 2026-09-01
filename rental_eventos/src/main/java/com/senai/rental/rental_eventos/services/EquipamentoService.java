package com.senai.rental.rental_eventos.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.rental.rental_eventos.models.Equipamento;
import com.senai.rental.rental_eventos.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository EquipamentoRepository;

    public Long contarEquipamentos() {
        return EquipamentoRepository.count();
    }

    public Equipamento buscarEquipamento(Integer id) {
        return EquipamentoRepository.findById(id).get();
    }    

    public List<Equipamento> listarEquipamentos() {
    List<Equipamento> equipamentos = EquipamentoRepository.findAll();

    equipamentos.sort(
        Comparator.comparing(
            Equipamento::getNome,
            String.CASE_INSENSITIVE_ORDER
        )
    );

    return equipamentos;
}

    public Boolean deletarEquipamento(Integer id) {
        if(EquipamentoRepository.existsById(id)) {
            EquipamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Equipamento cadastrarEquipamento(Equipamento Equipamento) {
        return EquipamentoRepository.save(Equipamento);

    }

    public Equipamento atualizarEquipamento(Integer id, Equipamento Equipamento) {
        Equipamento EquipamentoRecuperado = buscarEquipamento(id);
        if(EquipamentoRecuperado != null) {
            EquipamentoRecuperado.setId(id);
            if(Equipamento.getNome() != null) {
                EquipamentoRecuperado.setNome(Equipamento.getNome());
            }
           return EquipamentoRepository.save(EquipamentoRecuperado);
        } 
        return null;
       }
}
