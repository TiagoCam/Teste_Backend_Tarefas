package com.crja.testecrja.repository;

import com.crja.testecrja.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    public List<Pessoa> findAllByNome(String nome);

    public List<Pessoa> findAllByNomeContainingIgnoreCase(String nome);
}
