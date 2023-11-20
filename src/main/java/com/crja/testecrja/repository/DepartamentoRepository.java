package com.crja.testecrja.repository;

import com.crja.testecrja.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    public List<Departamento> findAllByTitulo(String titulo);

}
