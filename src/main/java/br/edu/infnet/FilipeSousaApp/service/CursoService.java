package br.edu.infnet.FilipeSousaApp.service;

import br.edu.infnet.FilipeSousaApp.dto.CursoDTO;
import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.repository.CursoRepository;
import br.edu.infnet.FilipeSousaApp.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    public Curso incluir(CursoDTO cursoDTO) {
        Instrutor instrutor = instrutorRepository.findById(cursoDTO.getInstrutorId())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o id: " + cursoDTO.getInstrutorId()));

        Curso curso = new Curso(
                cursoDTO.getTitulo(),
                cursoDTO.getDescricao(),
                cursoDTO.getCargaHoraria(),
                cursoDTO.getNivel(),
                cursoDTO.getStatus(),
                instrutor
        );

        curso.setId(UUID.randomUUID());

        return cursoRepository.save(curso);
    }

    public Curso incluir(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void excluir(UUID id) {
        cursoRepository.deleteById(id);
    }

    public Curso alterar(UUID id, CursoDTO cursoDTO) {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o id: " + id));

        Instrutor instrutor = instrutorRepository.findById(cursoDTO.getInstrutorId())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado com o id: " + cursoDTO.getInstrutorId()));

        cursoExistente.setTitulo(cursoDTO.getTitulo());
        cursoExistente.setDescricao(cursoDTO.getDescricao());
        cursoExistente.setCargaHoraria(cursoDTO.getCargaHoraria());
        cursoExistente.setNivel(cursoDTO.getNivel());
        cursoExistente.setStatus(cursoDTO.getStatus());
        cursoExistente.setInstrutor(instrutor);

        return cursoRepository.save(cursoExistente);
    }

    public Iterable<Curso> obterLista() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obterPorId(UUID id) {
        return cursoRepository.findById(id);
    }
}