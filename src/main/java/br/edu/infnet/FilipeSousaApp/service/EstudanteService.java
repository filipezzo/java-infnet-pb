package br.edu.infnet.FilipeSousaApp.service;

import br.edu.infnet.FilipeSousaApp.dto.EstudanteDTO;
import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.domain.Estudante;
import br.edu.infnet.FilipeSousaApp.repository.CursoRepository;
import br.edu.infnet.FilipeSousaApp.repository.EstudanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Estudante incluir(EstudanteDTO estudanteDTO) {
        Estudante estudante = new Estudante(
                estudanteDTO.getNome(),
                estudanteDTO.getEmail(),
                estudanteDTO.getTelefone(),
                estudanteDTO.getSenha()
        );

        if (estudanteDTO.getCursosIds() != null) {
            List<Curso> cursos = (List<Curso>) cursoRepository.findAllById(estudanteDTO.getCursosIds());
            estudante.setCursos(cursos);
        }

        return this.incluir(estudante);
    }

    public Estudante incluir(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public void excluir(Integer id) {
        estudanteRepository.deleteById(id);
    }

    public Estudante alterar(Integer id, EstudanteDTO estudanteDTO) {
        Estudante estudanteExistente = estudanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado com o id: " + id));

        estudanteExistente.setNome(estudanteDTO.getNome());
        estudanteExistente.setEmail(estudanteDTO.getEmail());
        estudanteExistente.setTelefone(estudanteDTO.getTelefone());
        estudanteExistente.setSenha(estudanteDTO.getSenha());

        if (estudanteDTO.getCursosIds() != null) {
            List<Curso> cursos = (List<Curso>) cursoRepository.findAllById(estudanteDTO.getCursosIds());
            estudanteExistente.setCursos(cursos);
        }

        return estudanteRepository.save(estudanteExistente);
    }

    public Iterable<Estudante> obterLista() {
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> obterPorId(Integer id) {
        return estudanteRepository.findById(id);
    }

    @Transactional
    public void imprimirListaCompleta() {
        System.out.println("✅ Carga de estudantes e matrículas concluída. Imprimindo lista:");
        for (Estudante estudante : obterLista()) {
            System.out.printf("Estudante: %s, Cursos Matriculados: %d\n",
                    estudante.getNome(), estudante.getCursos() != null ? estudante.getCursos().size() : 0);
        }
    }
}