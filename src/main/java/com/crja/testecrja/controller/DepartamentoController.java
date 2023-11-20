package com.crja.testecrja.controller;

import com.crja.testecrja.dto.departamento.DepartamentoCountDTO;
import com.crja.testecrja.dto.departamento.DepartamentoDTO;
import com.crja.testecrja.model.Departamento;
import com.crja.testecrja.model.Pessoa;
import com.crja.testecrja.repository.DepartamentoRepository;
import com.crja.testecrja.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    // Listar departamento e quantidade de pessoas e tarefas

    @GetMapping("/get/departamentos")
    public ResponseEntity<List<DepartamentoCountDTO>> getAll() {
        return ResponseEntity.ok(departamentoService.listarDepartamentos());
    }

    // Cadastrar departamento

    @PostMapping("/post/departamento")
    public ResponseEntity<Departamento> postDepartamento(@RequestBody DepartamentoDTO dto) {
        return departamentoService.postDepartamento(dto)
                .map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Editar departamento

    @PutMapping("/put/departamento/{id}")
    public ResponseEntity<Departamento> putDepartamento(@RequestBody DepartamentoDTO dto, @PathVariable("id") long id) {
        return departamentoService.putDepartamento(dto, id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    // Deletar departamento

    @DeleteMapping("/delete/departamento/{id}")
    public void deleteDepartamento(@PathVariable("id") long id) {
        departamentoRepository.deleteById((int) id);
    }
}
