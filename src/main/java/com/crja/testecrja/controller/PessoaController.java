package com.crja.testecrja.controller;

import com.crja.testecrja.dto.Pessoa.PessoaDTO;
import com.crja.testecrja.dto.Pessoa.PessoaHorasDTO;
import com.crja.testecrja.dto.Pessoa.PessoaMediaDTO;
import com.crja.testecrja.dto.Pessoa.PessoaMediaRetornoDTO;
import com.crja.testecrja.model.Pessoa;

import com.crja.testecrja.repository.PessoaRepository;

import com.crja.testecrja.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    // Listar pessoas trazendo nome, departamento, total horas gastas nas tarefas
    @GetMapping("/get/pessoas")
    public ResponseEntity<List<PessoaHorasDTO>> findAll() {
        return ResponseEntity.ok(pessoaService.listarPessoas());
    }

    // Buscar pessoas por nome e retorna média de horas gastas por tarefa.
    @GetMapping("/get/pessoas/gastos")
    public ResponseEntity<List<PessoaMediaRetornoDTO>> findByNomeMediaHoras(@RequestBody PessoaMediaDTO pessoaEntrada) {
        return ResponseEntity.ok(pessoaService.buscarPessoaMediaHoras(pessoaEntrada));
    }

    // Cadastrar Pessoa
    @PostMapping("/post/pessoas")
    public ResponseEntity<Pessoa> postPessoa(@RequestBody PessoaDTO dto) {
        return pessoaService.postPessoa(dto).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Editar Pessoa
    @PutMapping("/put/pessoas/{id}")
    public ResponseEntity<Pessoa> putPessoa(@RequestBody PessoaDTO dto, @PathVariable("id") long id) {
        return pessoaService.putPessoa(dto, id).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Deletar Pessoa
    @DeleteMapping("/delete/pessoas/{id}")
    public void deletePessoa(@PathVariable("id") long id) {
        pessoaRepository.deleteById((int) id);
    }


}
