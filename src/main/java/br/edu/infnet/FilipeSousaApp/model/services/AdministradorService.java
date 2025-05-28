package br.edu.infnet.FilipeSousaApp.model.services;
import br.edu.infnet.FilipeSousaApp.model.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.model.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador incluir(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public Iterable<Administrador> obterLista() {
        return administradorRepository.findAll();
    }
}
