package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.dto.EstudanteDTO;
import br.edu.infnet.FilipeSousaApp.domain.Estudante;
import br.edu.infnet.FilipeSousaApp.service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping("/incluir")
    public ResponseEntity<Estudante> incluir(@Valid @RequestBody EstudanteDTO estudanteDTO) {
        Estudante criado = estudanteService.incluir(estudanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> alterar(@PathVariable Integer id, @Valid @RequestBody EstudanteDTO estudanteDTO) {
        Estudante atualizado = estudanteService.alterar(id, estudanteDTO);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/lista")
    public ResponseEntity<Collection<Estudante>> obterLista() {
        Collection<Estudante> lista = (Collection<Estudante>) estudanteService.obterLista();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> obterPorId(@PathVariable Integer id) {
        return estudanteService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        estudanteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}