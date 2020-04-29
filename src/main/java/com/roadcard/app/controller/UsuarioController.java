package com.roadcard.app.controller;

import com.roadcard.app.controller.form.UsuarioForm;
import com.roadcard.app.controller.vo.UsuarioVO;
import com.roadcard.app.model.Usuario;
import com.roadcard.app.repository.UsuarioRepository;
import com.roadcard.app.util.FormatUtil;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/buscaPorCpfOuNome/{param}")
    public ResponseEntity<Usuario> findByCpfOrName(@PathVariable String param){

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

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioVO> atualizar(@PathVariable Long id,
                                               @RequestBody @Valid UsuarioForm form){

        Optional<Usuario> opt = usuarioRepository.findById(id);

        if(opt.isPresent()){
            Usuario usuario = form.atualizar(id, usuarioRepository);
            return ResponseEntity.ok(new UsuarioVO(usuario));
        }

            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){

        Optional<Usuario> opt = usuarioRepository.findById(id);
        if(opt.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioForm form){

        if(validaForm(form)){
            Usuario usuario = form.convert(form);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuario);
        }
            return ResponseEntity.badRequest().build();
    }

    private boolean validaForm(UsuarioForm form) {
        Usuario usuario = usuarioRepository.findByCpfOrNome(form.getCpf(), form.getNome());
        if(usuario != null){
            return false;
        }
        return true;
    }
}
