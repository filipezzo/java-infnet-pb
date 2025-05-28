package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.model.domain.Aula;
import br.edu.infnet.FilipeSousaApp.model.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AulaController {
    @Autowired
    private AulaService aulaService;
    @GetMapping("/aula")
    public Iterable<Aula> obterList(){
        return aulaService.obterLista();
    }

}
