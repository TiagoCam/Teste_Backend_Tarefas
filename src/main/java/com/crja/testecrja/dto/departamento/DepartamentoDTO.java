package com.crja.testecrja.dto.departamento;

import com.crja.testecrja.model.Departamento;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

public class DepartamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String titulo;

    public DepartamentoDTO(Departamento departamento) {
        super();
        this.titulo = departamento.getTitulo();
    }

    public DepartamentoDTO() {
        super();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}

