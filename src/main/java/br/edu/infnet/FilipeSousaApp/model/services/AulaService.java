package br.edu.infnet.FilipeSousaApp.model.services;
import br.edu.infnet.FilipeSousaApp.model.domain.Aula;
import br.edu.infnet.FilipeSousaApp.model.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;


    public Aula incluir(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Iterable<Aula> obterLista() {
        return aulaRepository.findAll();
    }
}
