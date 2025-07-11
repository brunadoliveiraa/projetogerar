package com.projetogerar.projetogerar.service;

import com.projetogerar.projetogerar.model.Indicacao;
import java.util.List;
import java.util.Optional;

public interface IndicacaoServiceInterface {
    List<Indicacao> listar();
    Optional<Indicacao> buscarPorId(int id);
    Indicacao salvar(Indicacao indicacao);
    Indicacao atualizar(int id, Indicacao indicacao);
    Indicacao adicionarNota(int id, int nota);
    Indicacao atualizarNota(int id, int notaAntiga, int notaNova);
    void deletar(int id);
}
