package br.edu.infnet.FilipeSousaApp.repository;

import br.edu.infnet.FilipeSousaApp.domain.Aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AulaRepository extends CrudRepository<Aula, UUID> {

}
