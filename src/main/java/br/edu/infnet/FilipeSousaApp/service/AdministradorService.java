package br.edu.infnet.FilipeSousaApp.service;

import br.edu.infnet.FilipeSousaApp.dto.AdministradorDTO;
import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador incluir(AdministradorDTO adminDTO) {
        Administrador administrador = new Administrador(
                adminDTO.getNome(),
                adminDTO.getEmail(),
                adminDTO.getTelefone(),
                adminDTO.getSenha(),
                adminDTO.getNivelAcesso()
        );
        return this.incluir(administrador);
    }

    public Administrador incluir(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public void excluir(Integer id) {
        administradorRepository.deleteById(id);
    }

    public Administrador alterar(Integer id, AdministradorDTO adminDTO) {
        Administrador adminExistente = administradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado com o id: " + id));

        adminExistente.setNome(adminDTO.getNome());
        adminExistente.setEmail(adminDTO.getEmail());
        adminExistente.setTelefone(adminDTO.getTelefone());
        adminExistente.setSenha(adminDTO.getSenha());
        adminExistente.setNivelAcesso(adminDTO.getNivelAcesso());

        return administradorRepository.save(adminExistente);
    }

    public Iterable<Administrador> obterLista() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> obterPorId(Integer id) {
        return administradorRepository.findById(id);
    }
}