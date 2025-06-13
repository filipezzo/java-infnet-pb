package br.edu.infnet.FilipeSousaApp.repository;

import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {


}
