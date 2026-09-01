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

import com.senai.rental.rental_eventos.models.Usuario;
import com.senai.rental.rental_eventos.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
  
    

    @GetMapping("/contar-usuario")
    public Long contarUsuarios() {
        return usuarioService.contarUsuarios();

    }

    @GetMapping("/buscar-usuario/{id}")
    public Usuario busUsuario (@PathVariable Integer id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping ("/listar-usuario")
    public List<Usuario> listaUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public String deletarUsuario(@PathVariable Integer id) {
        if(usuarioService.deletarUsuario(id)) {
            return "Usuário removido com sucesso.";
        
        }
        return "Falha ao remover Usuário.";
    }

     @PostMapping("/salvar-usuario")
     public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
     }

     @PutMapping("/atualizar-usuario/{id}")
     public String atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if(usuarioService.atualizarUsuario(id, usuario) != null) {
            return "Usuario atualizada com sucesso.";

        }
        return "Falha ao remover usuario.";
     }
    
    
}
