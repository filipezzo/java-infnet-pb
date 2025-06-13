package br.edu.infnet.FilipeSousaApp.service;

import br.edu.infnet.FilipeSousaApp.dto.AulaDTO;
import br.edu.infnet.FilipeSousaApp.domain.Aula;
import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.repository.AulaRepository;
import br.edu.infnet.FilipeSousaApp.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Aula incluir(AulaDTO aulaDTO) {
        Curso curso = cursoRepository.findById(aulaDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o id: " + aulaDTO.getCursoId()));

        Aula aula = new Aula(
                aulaDTO.getTitulo(),
                aulaDTO.getLink(),
                aulaDTO.getComentarios(),
                aulaDTO.getConcluido(),
                curso
        );
        return this.incluir(aula);
    }

    public Aula incluir(Aula aula) {
        return aulaRepository.save(aula);
    }

    public void excluir(UUID id) {
        aulaRepository.deleteById(id);
    }

    public Aula alterar(UUID id, AulaDTO aulaDTO) {
        Aula aulaExistente = aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada com o id: " + id));

        Curso curso = cursoRepository.findById(aulaDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o id: " + aulaDTO.getCursoId()));

        aulaExistente.setTitulo(aulaDTO.getTitulo());
        aulaExistente.setLink(aulaDTO.getLink());
        aulaExistente.setComentarios(aulaDTO.getComentarios());
        aulaExistente.setConcluido(aulaDTO.getConcluido());
        aulaExistente.setCurso(curso);

        return aulaRepository.save(aulaExistente);
    }

    public Iterable<Aula> obterLista() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> obterPorId(UUID id) {
        return aulaRepository.findById(id);
    }
}