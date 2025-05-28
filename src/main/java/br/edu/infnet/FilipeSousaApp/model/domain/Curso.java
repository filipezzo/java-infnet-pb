package br.edu.infnet.FilipeSousaApp.model.domain;

import jakarta.persistence.*;

@Entity
public class Curso {
    public enum NivelCurso {
        INICIANTE,
        INTERMEDIÁRIO,
        AVANÇADO
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String  id;
    public String titulo;
    public String descricao;
    public double cargaHoraria;
    @Enumerated(EnumType.STRING)
    public  NivelCurso nivel;
    public boolean status;

    public Curso() {

    }

    public Curso(String titulo, String descricao, double cargaHoraria, String nivel, String status)
    {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.nivel = NivelCurso.valueOf(nivel.trim().toUpperCase());
        this.status = Boolean.parseBoolean(status.trim());

    }

    @Override
    public String toString() {
        return "Curso: " + titulo +
                " | Nível: " + nivel +
                " | Carga horária: " + cargaHoraria + "h" +
                " | Publicado: " + (status ? "Sim" : "Não");
    }

}
