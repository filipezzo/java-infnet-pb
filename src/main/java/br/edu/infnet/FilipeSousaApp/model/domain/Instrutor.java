package br.edu.infnet.FilipeSousaApp.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
public class Instrutor extends Usuario {
    public boolean status;
    @Transient
    public List<Curso> cursosMinistrados;

    public Instrutor(){

    }
    public Instrutor(String nome, String email, String telefone, String senha, String tipo,
                     boolean status, List<Curso> cursosMinistrados) {

        super(nome, email, telefone, senha, tipo);
        this.status = status;
        this.cursosMinistrados = cursosMinistrados;
    }

    @Override
    public String toString() {
        return String.format("O instrutor %s de email %s foi cadastrado com sucesso!", nome, email);
    }
}
