package br.edu.infnet.FilipeSousaApp.controller;


import br.edu.infnet.FilipeSousaApp.model.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.model.services.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstrutorController {
    @Autowired
    private InstrutorService instrutorService;

    @GetMapping("/instrutor")
    public Iterable<Instrutor> obterLista(){
        return instrutorService.obterLista();
    }
}
