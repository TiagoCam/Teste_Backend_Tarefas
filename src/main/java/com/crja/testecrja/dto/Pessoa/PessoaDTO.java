package com.crja.testecrja.dto.Pessoa;

import com.crja.testecrja.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

public class PessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String nome;

    @NotBlank
    private long idDepartamento;

    public PessoaDTO(Pessoa pessoa) {
        super();
        this.nome = pessoa.getNome();
        this.idDepartamento = pessoa.getIdDepartamento().getId();
    }

    public PessoaDTO() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}
