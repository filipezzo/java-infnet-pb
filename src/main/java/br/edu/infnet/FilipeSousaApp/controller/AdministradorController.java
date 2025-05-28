package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.model.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.model.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;
    @GetMapping("/admin")
    public Iterable<Administrador> obterLista() {
        return administradorService.obterLista();
    }
}
