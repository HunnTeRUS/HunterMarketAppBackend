package com.hunter.cursomc.dto;

import com.hunter.cursomc.domain.Cliente;
import com.hunter.cursomc.services.validation.ClienteUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Size(min=5, message = "O tamanho tem de ser no minimo 5 caracteres e no maximo 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Email(message = "Email Invalido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
    }

    public ClienteDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
