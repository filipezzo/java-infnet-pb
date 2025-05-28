package br.edu.infnet.FilipeSousaApp.model.repository;

import br.edu.infnet.FilipeSousaApp.model.domain.Estudante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends CrudRepository<Estudante, Integer> {

}
