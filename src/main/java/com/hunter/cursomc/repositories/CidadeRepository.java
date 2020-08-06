package com.hunter.cursomc.repositories;

import com.hunter.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT C FROM Cidade C WHERE C.estado.id = :estadoId ORDER BY C.nome")
    public List<Cidade> findCidades(@Param("estadoId") Integer estadoId);
}
