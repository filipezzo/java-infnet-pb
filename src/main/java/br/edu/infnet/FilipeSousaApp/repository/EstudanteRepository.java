package br.edu.infnet.FilipeSousaApp.repository;

import br.edu.infnet.FilipeSousaApp.domain.Estudante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends CrudRepository<Estudante, Integer> {

}
