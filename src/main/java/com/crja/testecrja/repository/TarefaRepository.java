package com.crja.testecrja.repository;

import com.crja.testecrja.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    public List<Tarefa> findAllByTitulo(String titulo);
}
