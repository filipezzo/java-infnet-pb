package br.edu.infnet.FilipeSousaApp.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
@Table(name = "TAdministrador")
public class Administrador extends Usuario {
    public enum NivelAcesso {
        SUPERADMIN,
        MODERADOR
    }
    public NivelAcesso nivelAcesso;
    @Transient
    public List<Instrutor> cadastroInstrutores;

    public Administrador(){

    }

    public Administrador( String nome, String email, String telefone, String senha, String tipo, String nivelAcesso, List<Instrutor> cadastroInstrutores) {
        super(nome, email, telefone, senha, tipo);
        this.nivelAcesso = NivelAcesso.valueOf(nivelAcesso.trim().toUpperCase());
        this.cadastroInstrutores = cadastroInstrutores;
    }

    @Override
    public String toString() {
        return String.format("O administrador %s de email %s com tipo de acesso %s foi cadastrado com sucesso!", nome, email, tipo);
    }
}
