package br.edu.infnet.FilipeSousaApp.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String telefone;
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.tipo = tipo;
    }

    public enum TipoUsuario {
        ESTUDANTE,
        INSTRUTOR,
        ADMINISTRADOR
    }

    @Override
    public String toString() {
        return String.format("O usuário %s (tipo: %s, email: %s) foi cadastrado.",
                this.getNome(), this.getTipo(), this.getEmail());
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}