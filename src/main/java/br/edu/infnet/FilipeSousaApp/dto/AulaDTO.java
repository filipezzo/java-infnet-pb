package br.edu.infnet.FilipeSousaApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class AulaDTO {

    @NotBlank(message = "O campo 'titulo' da aula é obrigatório.")
    private String titulo;

    @NotBlank(message = "O campo 'link' da aula é obrigatório.")
    private String link;

    private String comentarios; // Opcionals

    @NotNull(message = "O campo 'concluido' é obrigatório.")
    private Boolean concluido;

    @NotNull(message = "O ID do curso é obrigatório.")
    private UUID cursoId;

    // Getters e Setters
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
    public Boolean getConcluido() {
        return concluido;
    }
    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
    public UUID getCursoId() {
        return cursoId;
    }
    public void setCursoId(UUID cursoId) {
        this.cursoId = cursoId;
    }
}