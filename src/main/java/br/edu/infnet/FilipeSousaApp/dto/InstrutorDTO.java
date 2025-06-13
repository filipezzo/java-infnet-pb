package br.edu.infnet.FilipeSousaApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InstrutorDTO {

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

    @NotNull(message = "O campo 'status' é obrigatório.")
    private Boolean status;

    @NotNull(message = "O ID do administrador é obrigatório.")
    private Integer administradorId;

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

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Integer getAdministradorId() {
        return administradorId;
    }
    public void setAdministradorId(Integer administradorId) {
        this.administradorId = administradorId;
    }
}