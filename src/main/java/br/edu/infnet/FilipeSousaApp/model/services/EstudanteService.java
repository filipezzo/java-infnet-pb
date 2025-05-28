package br.edu.infnet.FilipeSousaApp.model.services;
import br.edu.infnet.FilipeSousaApp.model.domain.Estudante;
import br.edu.infnet.FilipeSousaApp.model.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante incluir(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public Iterable<Estudante> obterLista() {
        return estudanteRepository.findAll();
    }
}
