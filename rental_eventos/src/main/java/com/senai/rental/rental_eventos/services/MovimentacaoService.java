package com.senai.rental.rental_eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.rental.rental_eventos.models.Movimentacao;
import com.senai.rental.rental_eventos.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Long contarMovimentacaos() {
        return movimentacaoRepository.count();
    }

    public Movimentacao buscarMovimentacao(Integer id) {
        return movimentacaoRepository.findById(id).orElse(null);
    }

    public List<Movimentacao> listarMovimentacaos() {
        return movimentacaoRepository.findAll();
    }

    public Boolean deletarMovimentacao(Integer id) {
        if (movimentacaoRepository.existsById(id)) {
            movimentacaoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao atualizarMovimentacao(Integer id, Movimentacao movimentacao) {

        Movimentacao movimentacaoRecuperada = buscarMovimentacao(id);

        if (movimentacaoRecuperada != null) {

            movimentacaoRecuperada.setTipo(movimentacao.getTipo());
            movimentacaoRecuperada.setData(movimentacao.getData());
            movimentacaoRecuperada.setQuantidade(movimentacao.getQuantidade());
            movimentacaoRecuperada.setEquipamento_id(movimentacao.getEquipamento_id());
            movimentacaoRecuperada.setUsuario_id(movimentacao.getUsuario_id());
            movimentacaoRecuperada.setEquipamento(movimentacao.getEquipamento());
            movimentacaoRecuperada.setUsuario(movimentacao.getUsuario());

            return movimentacaoRepository.save(movimentacaoRecuperada);
        }

        return null;
    }
}