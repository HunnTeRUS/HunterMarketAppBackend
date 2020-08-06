package com.hunter.cursomc.repositories;


import com.hunter.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly=true)
    Cliente findByEmail(String email);
}
