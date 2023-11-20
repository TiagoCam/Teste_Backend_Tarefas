package com.crja.testecrja.controller;

import com.crja.testecrja.dto.tarefa.TarefaDTO;
import com.crja.testecrja.dto.tarefa.TarefaIdDTO;
import com.crja.testecrja.model.Pessoa;
import com.crja.testecrja.model.Tarefa;
import com.crja.testecrja.repository.TarefaRepository;


import com.crja.testecrja.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private TarefaRepository tarefaRepository;

    // Buscar todas tarefas
    @GetMapping("/get/tarefas/all")
    public ResponseEntity<List<Tarefa>> getAll() {
        return ResponseEntity.ok(tarefaService.findAll());
    }

    // Cadastrar tarefa
    @PostMapping("/post/tarefas")
    public ResponseEntity<TarefaDTO> postTarefa(@RequestBody TarefaDTO dto) {
        return tarefaService.postTarefa(dto).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Editar tarefa
    @PutMapping("/put/tarefas/{id}")
    public ResponseEntity<Tarefa> putTarefa(@RequestBody TarefaDTO dto, @PathVariable("id") long id) {
        return tarefaService.putTarefa(dto, id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Alocar uma pessoa na tarefa que tenha o mesmo departamento
    @PutMapping("/put/tarefas/alocar/{id}")
    public ResponseEntity<TarefaIdDTO> alocarPessoaTarefa(@RequestBody TarefaIdDTO alocarDTO, @PathVariable("id") long id) {
        return tarefaService.alocarPessoaTarefa(alocarDTO, id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Finalizar a tarefa
    @PutMapping("/put/tarefas/finalizar/{id}")
    public ResponseEntity<Long> finalizarTarefa(@PathVariable("id") long finalizarTarefa) {
        return tarefaService.finalizarTarefa(finalizarTarefa).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Deletar tarefa
    @DeleteMapping("/delete/tarefa/{id}")
    public void deleteTarefa(@PathVariable("id") long id) {
        tarefaRepository.deleteById((int) id);
    }

}
