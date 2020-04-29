package com.roadcard.app.controller.vo;

import com.roadcard.app.model.Usuario;

public class UsuarioVO {

    private Long id;
    private String nome;
    private String cpf;

    public UsuarioVO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
