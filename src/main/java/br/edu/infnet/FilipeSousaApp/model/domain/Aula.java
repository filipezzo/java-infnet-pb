package br.edu.infnet.FilipeSousaApp.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
    public String titulo;
    public String link;
    public String comentarios;
    public boolean concluido;

    public Aula(){

    }

    public Aula(String titulo, String link, String comentarios, boolean concluido) {
        this.titulo = titulo;
        this.link = link;
        this.comentarios = comentarios;
        this.concluido = false;
    }

    @Override
    public String toString() {
        return String.format("Aula: %s | ID: %s | Link: %s | Comentários: %s | Concluída: %s",
                titulo, id, link, comentarios, concluido ? "Sim" : "Não");
    }
}
