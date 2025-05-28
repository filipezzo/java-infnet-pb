package br.edu.infnet.FilipeSousaApp.model.repository;

import br.edu.infnet.FilipeSousaApp.model.domain.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository  extends CrudRepository<Curso, UUID> {
}
