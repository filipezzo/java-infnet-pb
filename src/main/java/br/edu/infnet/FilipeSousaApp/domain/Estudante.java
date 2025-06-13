package br.edu.infnet.FilipeSousaApp.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estudante extends Usuario {

    private int pontos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "estudante_curso",
            joinColumns = @JoinColumn(name = "estudante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    public Estudante() {
    }

    public Estudante(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha, TipoUsuario.ESTUDANTE);
        this.pontos = 0;
    }

    @Override
    public String toString() {
        return String.format("Estudante: %s (Email: %s, Pontos: %d)",
                getNome(), getEmail(), this.pontos);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}