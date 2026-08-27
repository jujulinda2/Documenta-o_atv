package com.senai.rental.rental_eventos.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="tipo")
    private String tipo;

    @Column(name="data")
    private LocalDate data;

    @Column(name="quantidade")
    private Integer quantidade;

     @Column(name="equipamento_id")
    private Integer equipamento_id;
    
    @Column(name="usuario_id")
    private Integer usuario_id;
    
    
        @ManyToOne
        @JoinColumn(name = "equipamento_id", nullable = false)
        private Equipamento equipamento;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario;

        public Movimentacao() {
        }

        public Movimentacao(Integer id, String tipo, LocalDate data, Integer quantidade, Integer equipamento_id,
                Integer usuario_id, Equipamento equipamento, Usuario usuario) {
            this.id = id;
            this.tipo = tipo;
            this.data = data;
            this.quantidade = quantidade;
            this.equipamento_id = equipamento_id;
            this.usuario_id = usuario_id;
            this.equipamento = equipamento;
            this.usuario = usuario;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public LocalDate getData() {
            return data;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }

        public Integer getEquipamento_id() {
            return equipamento_id;
        }

        public void setEquipamento_id(Integer equipamento_id) {
            this.equipamento_id = equipamento_id;
        }

        public Integer getUsuario_id() {
            return usuario_id;
        }

        public void setUsuario_id(Integer usuario_id) {
            this.usuario_id = usuario_id;
        }

        public Equipamento getEquipamento() {
            return equipamento;
        }

        public void setEquipamento(Equipamento equipamento) {
            this.equipamento = equipamento;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        
    
    
}
