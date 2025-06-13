package br.edu.infnet.FilipeSousaApp.repository;

import br.edu.infnet.FilipeSousaApp.domain.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository  extends CrudRepository<Curso, UUID> {
}
