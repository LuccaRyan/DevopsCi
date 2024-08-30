package com.example.dbpicpay.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
    //os atributos não podem ser vazios
    @Id
    //@Size(min = 11, max = 11, message = "CPF deve ter 11 digitos")
    @NotNull(message = "O cpf não pode ser vazio")
    @CPF(message = "CPF invalido")
    private String cpf;
    @NotNull(message = "O nome não pode ser vazio")
    @Size(min = 1, max = 250, message = "O nome deve ter entre 1 e 250 caracteres")
    private String nome;
    @NotNull(message = "O email não pode ser vazio")
    @Size(min = 10, max = 250, message = "O email deve ter entre 10 e 250 caracteres")
    @Email
    private String email;
    @NotNull(message = "O telefone não pode ser vazio")
    @Size(min = 11, max = 15, message = "O telefone deve ter entre 11 e 15 caracteres")
    private String telefone;

    public Cliente() {}

    public Cliente(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente" + "\ncpf:" + cpf + "\nnome:" + nome + "\nemail:" + email + "\ntelefone:" + telefone;
    }
}
