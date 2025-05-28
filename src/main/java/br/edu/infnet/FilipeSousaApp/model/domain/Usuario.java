package br.edu.infnet.FilipeSousaApp.model.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {
    public enum TipoUsuario {
        ESTUDANTE,
        INSTRUTOR,
        ADMINISTRADOR
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nome;
    public String email;
    public String telefone;
    public String senha;
    public TipoUsuario tipo;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String senha, String tipo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.tipo = TipoUsuario.valueOf(tipo.toUpperCase());
    }

    @Override
    public String toString() {
        return "O usuário " + nome + " - do tipo " + tipo + " - email " + email +
                " - telefone " + telefone + " foi cadastrado com sucesso!";
    }

}
