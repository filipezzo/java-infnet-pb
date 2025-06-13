package br.edu.infnet.FilipeSousaApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Curso {
    @Id
    private UUID id;

    private String titulo;
    private String descricao;
    private double cargaHoraria;

    @Enumerated(EnumType.STRING)
    private NivelCurso nivel;

    private boolean status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Aula> aulas;

    public Curso() {
    }

    public Curso(String titulo, String descricao, double cargaHoraria, NivelCurso nivel, boolean status, Instrutor instrutor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.nivel = nivel;
        this.status = status;
        this.instrutor = instrutor;
    }

    public enum NivelCurso {
        INICIANTE,
        INTERMEDIARIO,
        AVANCADO
    }

    @Override
    public String toString() {
        return String.format("Curso: %s | Nível: %s | Carga: %.1fh | Publicado: %s",
                this.getTitulo(), this.getNivel(), this.getCargaHoraria(), (this.isStatus() ? "Sim" : "Não"));
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
    public NivelCurso getNivel() {
        return nivel;
    }
    public void setNivel(NivelCurso nivel) {
        this.nivel = nivel;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Instrutor getInstrutor() {
        return instrutor;
    }
    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
    public List<Aula> getAulas() {
        return aulas;
    }
    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}