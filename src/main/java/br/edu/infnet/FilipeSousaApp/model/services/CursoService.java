package br.edu.infnet.FilipeSousaApp.model.services;
import br.edu.infnet.FilipeSousaApp.model.domain.Curso;
import br.edu.infnet.FilipeSousaApp.model.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso incluir(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Iterable<Curso> obterLista() {
        return cursoRepository.findAll();
    }
}
