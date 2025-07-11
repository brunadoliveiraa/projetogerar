package com.projetogerar.projetogerar.controller;

import com.projetogerar.projetogerar.model.Comentario;
import com.projetogerar.projetogerar.service.ComentarioServiceInterface;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    private final ComentarioServiceInterface service;

    public ComentarioController(ComentarioServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public List<Comentario> listar() {
        return service.listar();
    }

    @PostMapping
    public Comentario criar(@RequestBody Comentario comentario) {
        return service.salvar(comentario);
    }

    @PutMapping("/{id}")
    public Comentario atualizar(@PathVariable int id, @RequestBody Comentario comentario) {
        return service.atualizar(id, comentario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        service.deletar(id);
    }
}
