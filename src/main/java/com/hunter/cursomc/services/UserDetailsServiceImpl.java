package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Cliente;
import com.hunter.cursomc.repositories.ClienteRepository;
import com.hunter.cursomc.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = repo.findByEmail(email);
        if(cliente==null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(cliente.getId(), cliente.getEmail(), cliente.getSenha(), cliente.getPerfis());
    }
}
