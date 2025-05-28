package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.model.domain.Curso;
import br.edu.infnet.FilipeSousaApp.model.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;
    @GetMapping("/curso")
    public Iterable<Curso> obterLista(){
        return cursoService.obterLista();
    }
}
