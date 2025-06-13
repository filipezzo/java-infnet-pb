package br.edu.infnet.FilipeSousaApp.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Administrador extends Usuario {

    @Enumerated(EnumType.STRING)
    private NivelAcesso nivelAcesso;

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Instrutor> cadastroInstrutores;

    public Administrador() {
        super();
    }

    public Administrador(String nome, String email, String telefone, String senha, NivelAcesso nivelAcesso) {
        super(nome, email, telefone, senha, Usuario.TipoUsuario.ADMINISTRADOR);
        this.nivelAcesso = nivelAcesso;
    }

    public enum NivelAcesso {
        SUPERADMIN,
        MODERADOR
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public List<Instrutor> getCadastroInstrutores() {
        return cadastroInstrutores;
    }

    public void setCadastroInstrutores(List<Instrutor> cadastroInstrutores) {
        this.cadastroInstrutores = cadastroInstrutores;
    }

    @Override
    public String toString() {
        return String.format("O administrador %s (nível: %s) de email %s foi cadastrado com sucesso!",
                getNome(), getNivelAcesso(), getEmail());
    }
}