package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Cidade;
import com.hunter.cursomc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repo;

    public List<Cidade> findAll(Integer estadoId) {
        return repo.findCidades(estadoId);
    }
}
