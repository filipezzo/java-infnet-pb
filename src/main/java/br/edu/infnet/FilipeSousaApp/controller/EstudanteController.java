package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.model.domain.Estudante;
import br.edu.infnet.FilipeSousaApp.model.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping("/estudante")
    public Iterable<Estudante> obterLista(){
        return estudanteService.obterLista();
    }
}
