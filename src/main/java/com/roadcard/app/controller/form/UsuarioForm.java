package com.roadcard.app.controller.form;

import com.roadcard.app.model.Usuario;
import com.roadcard.app.repository.UsuarioRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario atualizar(Long id, UsuarioRepository repository){
        Usuario usuario = repository.getOne(id);
        usuario.setCpf(this.cpf);
        usuario.setNome(this.nome);
        repository.save(usuario);
        return usuario;
    }

    public Usuario convert(UsuarioForm form) {
        return new Usuario(form.getNome(), form.getCpf());
    }
}
