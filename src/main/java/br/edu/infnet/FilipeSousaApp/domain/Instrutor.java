package br.edu.infnet.FilipeSousaApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Instrutor extends Usuario {

    private boolean status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursosMinistrados;

    public Instrutor() {
    }

    public Instrutor(String nome, String email, String telefone, String senha, boolean status, Administrador administrador) {
        super(nome, email, telefone, senha, Usuario.TipoUsuario.INSTRUTOR);
        this.status = status;
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return String.format("Instrutor: %s (Email: %s, Status: %s)",
                getNome(), getEmail(), this.isStatus() ? "Ativo" : "Inativo");
    }

    public boolean isStatus() {

        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Curso> getCursosMinistrados() {
        return cursosMinistrados;
    }

    public void setCursosMinistrados(List<Curso> cursosMinistrados) {
        this.cursosMinistrados = cursosMinistrados;
    }
}