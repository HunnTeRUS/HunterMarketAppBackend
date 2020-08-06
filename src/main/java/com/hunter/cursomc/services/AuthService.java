package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.Cliente;
import com.hunter.cursomc.repositories.ClienteRepository;
import com.hunter.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    private Random rand = new Random();

    public void sendNewPassword(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) throw new ObjectNotFoundException("Email não encontrado");

        String newPass = newPassword();
        cliente.setSenha(passwordEncoder.encode(newPass));

        clienteRepository.save(cliente);
        emailService.sendNewPasswordHtmlEmail(cliente, newPass);
    }

    public String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    public char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) {         //Gera numero
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) {  //Gera letra Maiuscula
            return (char) (rand.nextInt(26) + 64);
        } else {                //Gera letra minuscula
            return (char) (rand.nextInt(10) + 48);
        }
    }
}
