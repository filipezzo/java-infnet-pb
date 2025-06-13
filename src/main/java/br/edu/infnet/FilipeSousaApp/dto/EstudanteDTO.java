package br.edu.infnet.FilipeSousaApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

public class EstudanteDTO {

    @NotBlank(message = "O campo 'nome' é obrigatório.")
    @Size(min = 2, max = 100)
    private String nome;

    @NotBlank(message = "O campo 'email' é obrigatório.")
    @Email(message = "O formato do email é inválido.")
    private String email;

    @NotBlank(message = "O campo 'telefone' é obrigatório.")
    private String telefone;

    @NotBlank(message = "O campo 'senha' é obrigatório.")
    @Size(min = 6)
    private String senha;

    private List<UUID> cursosIds;

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
    public List<UUID> getCursosIds() {
        return cursosIds;
    }
    public void setCursosIds(List<UUID> cursosIds) {
        this.cursosIds = cursosIds;
    }
}