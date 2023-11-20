package com.crja.testecrja.service;

import com.crja.testecrja.dto.tarefa.TarefaDTO;
import com.crja.testecrja.dto.tarefa.TarefaIdDTO;
import com.crja.testecrja.model.Departamento;
import com.crja.testecrja.model.Pessoa;
import com.crja.testecrja.model.Tarefa;
import com.crja.testecrja.repository.DepartamentoRepository;
import com.crja.testecrja.repository.PessoaRepository;
import com.crja.testecrja.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    // Cadastrar nova tarefa
    public Optional<TarefaDTO> postTarefa(@RequestBody TarefaDTO dto) {
        if (tarefaRepository.findAllByTitulo(dto.getTitulo()).isEmpty()
                && departamentoRepository.findById((int) dto.getIdDepartamento()).isPresent()) {
            Departamento departamento = new Departamento();
            departamento.setId(dto.getIdDepartamento());
            Tarefa tarefa = new Tarefa(dto.getTitulo(), dto.getDescricao(), dto.getPrazo(), dto.getDuracao(),
                    departamento);
            tarefaRepository.save(tarefa);
            return Optional.of(dto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Possiveis erros: Nome da Tarefa já existente ou Departamento não localizado!!!!", null);
        }
    }

    // Editar tarefa
    public Optional<Tarefa> putTarefa(@RequestBody TarefaDTO dto, long id) {
        if (tarefaRepository.findById((int) id).isPresent()
                && departamentoRepository.findById((int) dto.getIdDepartamento()).isPresent()) {
            Tarefa tarefa = tarefaRepository.getById((int) id);
            Departamento departamento = new Departamento();
            tarefa.setTitulo(dto.getTitulo());
            tarefa.setDescricao(dto.getDescricao());
            tarefa.setPrazo(dto.getPrazo());
            tarefa.setDuracao(dto.getDuracao());
            departamento.setId(dto.getIdDepartamento());
            tarefa.setIdDepartamento(departamento);
            return Optional.of(tarefaRepository.save(tarefa));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Possiveis erros: Nome da Tarefa já existente ou Departamento não localizado!!!!", null);
        }
    }

    // Alocar uma pessoa na tarefa que tenha o mesmo departamento
    public Optional<TarefaIdDTO> alocarPessoaTarefa(@RequestBody TarefaIdDTO alocarDTO, long id) {
        Tarefa tarefa = tarefaRepository.getById((int) alocarDTO.getIdTarefa());
        Pessoa pessoa = pessoaRepository.getById((int) id);
        if (tarefaRepository.findById((int) id).isPresent() && pessoaRepository.findById((int) id).isPresent()
                && tarefa.getIdDepartamento() == pessoa.getIdDepartamento()) {
            tarefa.setPessoa(pessoa);
            tarefaRepository.save(tarefa);
            return Optional.of(alocarDTO);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Possiveis erros: Departamentos diferentes ou não encontrado pessoa/tarefa!!!!", null);
        }
    }

    // Finalizar a tarefa
    public Optional<Long> finalizarTarefa(long finalizarTarefa) {
        if (tarefaRepository.findById((int) finalizarTarefa).isPresent()) {
            Tarefa tarefa = tarefaRepository.getById((int) finalizarTarefa);
            tarefa.setFinalizado(true);
            tarefaRepository.save(tarefa);
            return Optional.of(finalizarTarefa);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID não localizado!!!!", null);
        }
    }

    // Buscar todas tarefas
    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

}
