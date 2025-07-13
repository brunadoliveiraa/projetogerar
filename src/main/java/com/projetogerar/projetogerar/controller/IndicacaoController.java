package com.projetogerar.projetogerar.controller;

import com.projetogerar.projetogerar.model.Indicacao;
import com.projetogerar.projetogerar.service.IndicacaoServiceInterface;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/indicacao")
public class IndicacaoController {

    private final IndicacaoServiceInterface service;

    public IndicacaoController(IndicacaoServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Optional<Indicacao> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<Indicacao> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Indicacao> criar(@RequestBody @Valid Indicacao indicacao) {
        return ResponseEntity.ok(service.salvar(indicacao));
    }

    @PutMapping("/{id}")
    public Indicacao atualizar(@PathVariable int id, @RequestBody @Valid Indicacao indicacao) {
        return service.atualizar(id, indicacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        service.deletar(id);
    }
}


