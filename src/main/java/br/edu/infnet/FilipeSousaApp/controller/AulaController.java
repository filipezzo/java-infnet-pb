package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.dto.AulaDTO;
import br.edu.infnet.FilipeSousaApp.domain.Aula;
import br.edu.infnet.FilipeSousaApp.service.AulaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping("/incluir")
    public ResponseEntity<Aula> incluir(@Valid @RequestBody AulaDTO aulaDTO) {
        Aula criado = aulaService.incluir(aulaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> alterar(@PathVariable UUID id, @Valid @RequestBody AulaDTO aulaDTO) {
        Aula atualizado = aulaService.alterar(id, aulaDTO);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/lista")
    public ResponseEntity<Collection<Aula>> obterLista() {
        Collection<Aula> lista = (Collection<Aula>) aulaService.obterLista();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> obterPorId(@PathVariable UUID id) {
        return aulaService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        aulaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}