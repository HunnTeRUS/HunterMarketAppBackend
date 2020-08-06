package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Estado;
import com.hunter.cursomc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repo;

    public List<Estado> findAllStates(){
        return repo.findAllByOrderByNome();
    }
}
