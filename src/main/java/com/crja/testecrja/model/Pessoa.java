package com.crja.testecrja.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "TB_PESSOAS")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"pessoa", "idDepartamento"})
    private List<Tarefa> tarefa;

    @ManyToOne
    @JsonIgnoreProperties({"pessoa", "tarefa"})
    @JoinColumn(name = "idDepartamento")
    private Departamento idDepartamento;

    public Pessoa(String nome, Departamento departamento) {
        super();
        this.nome = nome;
        this.idDepartamento = departamento;
    }

    public Pessoa() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tarefa> getTarefa() {
        return tarefa;
    }

    public void setTarefa(List<Tarefa> tarefa) {
        this.tarefa = tarefa;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}

