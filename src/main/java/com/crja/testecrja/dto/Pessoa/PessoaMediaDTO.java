package com.crja.testecrja.dto.Pessoa;

import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

public class PessoaMediaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String nome;

    public PessoaMediaDTO(@NotNull String nome) {
        super();
        this.nome = nome;

    }

    public PessoaMediaDTO() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

