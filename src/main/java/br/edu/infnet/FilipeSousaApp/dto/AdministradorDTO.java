package br.edu.infnet.FilipeSousaApp.dto;

import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdministradorDTO {

    @NotBlank(message = "O campo 'nome' é obrigatório.")
    @Size(min = 2, max = 100)
    private String nome;

    @NotBlank(message = "O campo 'email' é obrigatório.")
    @Email(message = "O formato do email é inválido.")
    private String email;

    @NotBlank(message = "O campo 'telefone' é obrigatório.")
    private String telefone;

    @NotBlank(message = "O campo 'senha' é obrigatório.")
    @Size(min = 4)
    private String senha;

    @NotNull(message = "O campo 'nivelAcesso' é obrigatório.")
    private Administrador.NivelAcesso nivelAcesso;

    // Getters e Setters para todos os campos
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Administrador.NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }
    public void setNivelAcesso(Administrador.NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}