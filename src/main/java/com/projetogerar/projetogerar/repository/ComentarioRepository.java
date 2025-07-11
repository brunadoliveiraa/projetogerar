package com.projetogerar.projetogerar.repository;

import com.projetogerar.projetogerar.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
