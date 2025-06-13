package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.dto.CursoDTO;
import br.edu.infnet.FilipeSousaApp.domain.Curso;
import br.edu.infnet.FilipeSousaApp.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/incluir")
    public ResponseEntity<Curso> incluir(@Valid @RequestBody CursoDTO cursoDTO) {
        Curso criado = cursoService.incluir(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> alterar(@PathVariable UUID id, @Valid @RequestBody CursoDTO cursoDTO) {
        Curso atualizado = cursoService.alterar(id, cursoDTO);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/lista")
    public ResponseEntity<Collection<Curso>> obterLista() {
        Collection<Curso> lista = (Collection<Curso>) cursoService.obterLista();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obterPorId(@PathVariable UUID id) {
        return cursoService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        cursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}