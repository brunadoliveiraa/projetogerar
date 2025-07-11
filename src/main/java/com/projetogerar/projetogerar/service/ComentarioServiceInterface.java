package com.projetogerar.projetogerar.service;

import com.projetogerar.projetogerar.model.Comentario;
import java.util.List;

public interface ComentarioServiceInterface {
    List<Comentario> listar();

    Comentario salvar(Comentario comentario);

    Comentario atualizar(int id, Comentario comentario);

    void deletar(int id);
}
