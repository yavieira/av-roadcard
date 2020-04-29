package com.roadcard.app.controller;

import com.roadcard.app.model.Usuario;
import com.roadcard.app.repository.UsuarioRepository;
import com.roadcard.app.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/buscaPorCpfOuNome/{param}")
    public ResponseEntity<Usuario> findByCpf(@PathVariable String param){

        Usuario usuario = null;

        if(FormatUtil.validaCpf(param)){
            usuario = usuarioRepository.findByCpfOrNome(param, "");
        } else {
            usuario = usuarioRepository.findByCpfOrNome("", param);
        }

        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Usuario> lista(){

        List<Usuario> usuarios = usuarioRepository.findAll();

        if(usuarios != null && !usuarios.isEmpty()){
            return usuarios;
        }
        return null;
    }

    
}
