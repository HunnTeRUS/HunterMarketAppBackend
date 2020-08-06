package com.hunter.cursomc.dto;

import com.hunter.cursomc.services.validation.ClienteInsert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ClienteInsert
public class ClienteNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Size(min=5, message = "O tamanho tem de ser no minimo 5 caracteres e no maximo 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Email(message = "Email Invalido")
    private String email;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String cpfOuCnpj;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String logradouro;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String numero;

    private String complemento;
    private String bairro;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String cep;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer tipo;

    private Integer cidadeId;

    @NotEmpty
    @Size(min = 6, message = "A senha precisa ter no mínimo 6 caracteres")
    private String senha;

    public ClienteNewDTO() {
    }

    public ClienteNewDTO(String nome, String email, String cpfOuCnpj, String logradouro, String numero, String complemento, String bairro, String cep, String telefone1, String telefone2, String telefone3, Integer tipo, Integer cidadeId) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.tipo = tipo;
        this.cidadeId = cidadeId;
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

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

