package br.edu.infnet.FilipeSousaApp.model.repository;

import br.edu.infnet.FilipeSousaApp.model.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {


}
