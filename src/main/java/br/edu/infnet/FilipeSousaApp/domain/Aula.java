package br.edu.infnet.FilipeSousaApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String link;
    private String comentarios;
    private boolean concluido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Aula(){
    }

    public Aula(String titulo, String link, String comentarios, boolean concluido, Curso curso) {
        this.titulo = titulo;
        this.link = link;
        this.comentarios = comentarios;
        this.concluido = concluido;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return String.format("Aula: %s | Link: %s | Concluída: %s | Curso: %s",
                getTitulo(), getLink(), isConcluido() ? "Sim" : "Não", getCurso() != null ? getCurso().getTitulo() : "N/A");
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public boolean isConcluido() {
        return concluido;
    }
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}