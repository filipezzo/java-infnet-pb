package br.edu.infnet.FilipeSousaApp.dto;

import br.edu.infnet.FilipeSousaApp.domain.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CursoDTO {

    @NotBlank(message = "O título do curso é obrigatório.")
    @Size(min = 3, max = 100)
    private String titulo;

    @NotBlank(message = "A descrição do curso é obrigatória.")
    @Size(min = 10, max = 255)
    private String descricao;

    @Positive(message = "A carga horária deve ser um valor positivo.")
    private double cargaHoraria;

    @NotNull(message = "O nível do curso é obrigatório.")
    private Curso.NivelCurso nivel;

    @NotNull(message = "O status do curso é obrigatório.")
    private Boolean status;

    @NotNull(message = "O ID do instrutor é obrigatório.")
    private Integer instrutorId;

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public Curso.NivelCurso getNivel() {
        return nivel;
    }
    public void setNivel(Curso.NivelCurso nivel) {
        this.nivel = nivel;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Integer getInstrutorId() {
        return instrutorId;
    }
    public void setInstrutorId(Integer instrutorId) {
        this.instrutorId = instrutorId;
    }
}