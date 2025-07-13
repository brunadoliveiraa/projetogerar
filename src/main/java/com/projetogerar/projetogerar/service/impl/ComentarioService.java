package com.projetogerar.projetogerar.service.impl;

import com.projetogerar.projetogerar.model.Comentario;
import com.projetogerar.projetogerar.repository.ComentarioRepository;
import com.projetogerar.projetogerar.service.ComentarioServiceInterface;
import com.projetogerar.projetogerar.service.IndicacaoServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService implements ComentarioServiceInterface {

    private final ComentarioRepository repository;
    private final IndicacaoServiceInterface indicacaoService;

    public ComentarioService(ComentarioRepository repository, IndicacaoServiceInterface indicacaoService) {
        this.repository = repository;
        this.indicacaoService = indicacaoService;
    }

    @Override
    public List<Comentario> listar() {
        return repository.findAll();
    }

    @Override
    public Comentario salvar(Comentario comentario) {

        indicacaoService.adicionarNota(comentario.getIndicacao().getId(), comentario.getNota());

        return repository.save(comentario);
    }

    @Override
    public Comentario atualizar(int id, Comentario comentario) {
        Comentario comentarioAntigo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario com id " + id +" não encontrado."));

        // substituindo autora e indicacao que sao imutaveis
        comentario.setAutora(comentarioAntigo.getAutora());
        comentario.setIndicacao(comentarioAntigo.getIndicacao());

        repository.save(comentario);

        indicacaoService.atualizarNota(
                comentario.getIndicacao().getId(),
                comentarioAntigo.getNota(),
                comentario.getNota());

        return comentario;
    }

    @Override
    public void deletar(int id) {
        Comentario comentario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario com id " + id +" não encontrado."));

        repository.deleteById(id);
        indicacaoService.removerNota(comentario.getIndicacao().getId(), comentario.getNota());
    }
}
