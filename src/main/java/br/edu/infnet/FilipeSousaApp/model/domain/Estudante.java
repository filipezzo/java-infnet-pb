package br.edu.infnet.FilipeSousaApp.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class Estudante extends Usuario {
    public int pontos;

    @Transient
    public List<Curso> cursos;

    public Estudante(){

    }
    public Estudante
            (String nome, String email, String telefone, String senha,
             List<Curso> cursos)
    {
        super(nome, email, telefone, senha, String.valueOf(TipoUsuario.ESTUDANTE));
        this.cursos = cursos;
        this.pontos = 0;
    }

    @Override
    public String toString() {
        return String.format("O estudante %s de email %s foi cadastrado com sucesso!", nome, email);
    }
}
