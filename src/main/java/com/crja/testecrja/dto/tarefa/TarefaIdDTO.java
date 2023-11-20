package com.crja.testecrja.dto.tarefa;


import com.crja.testecrja.model.Tarefa;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class TarefaIdDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private long idTarefa;

    public TarefaIdDTO(Tarefa tarefa) {
        super();
        this.idTarefa = tarefa.getId();
    }

    public TarefaIdDTO() {
        super();
    }

    public long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(long idTarefa) {
        this.idTarefa = idTarefa;
    }

}
