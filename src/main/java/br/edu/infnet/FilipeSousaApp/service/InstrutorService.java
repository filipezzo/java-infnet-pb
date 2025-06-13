package br.edu.infnet.FilipeSousaApp.service;
import br.edu.infnet.FilipeSousaApp.dto.InstrutorDTO;
import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.repository.AdministradorRepository;
import br.edu.infnet.FilipeSousaApp.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    public Instrutor incluir(InstrutorDTO instrutorDTO) {
        Administrador admin = administradorRepository.findById(instrutorDTO.getAdministradorId())
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado com o id: " + instrutorDTO.getAdministradorId()));

        Instrutor instrutor = new Instrutor(
                instrutorDTO.getNome(),
                instrutorDTO.getEmail(),
                instrutorDTO.getTelefone(),
                instrutorDTO.getSenha(),
                instrutorDTO.getStatus(),
                admin
        );
        return this.incluir(instrutor);
    }

    public Instrutor incluir(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public void excluir(Integer id) {
        instrutorRepository.deleteById(id);
    }

    public Instrutor alterar(Integer id, InstrutorDTO instrutorDTO) {
        Instrutor instrutorExistente = instrutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o id: " + id));

        Administrador admin = administradorRepository.findById(instrutorDTO.getAdministradorId())
                .orElseThrow(() -> new RuntimeException("Administrador não encontrado com o id: " + instrutorDTO.getAdministradorId()));

        instrutorExistente.setNome(instrutorDTO.getNome());
        instrutorExistente.setEmail(instrutorDTO.getEmail());
        instrutorExistente.setTelefone(instrutorDTO.getTelefone());
        instrutorExistente.setSenha(instrutorDTO.getSenha());
        instrutorExistente.setStatus(instrutorDTO.getStatus());
        instrutorExistente.setAdministrador(admin);

        return instrutorRepository.save(instrutorExistente);
    }

    public Iterable<Instrutor> obterLista() {
        return instrutorRepository.findAll();
    }

    public Optional<Instrutor> obterPorId(Integer id) {
        return instrutorRepository.findById(id);
    }
}