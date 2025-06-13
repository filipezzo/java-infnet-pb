package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.dto.InstrutorDTO;
import br.edu.infnet.FilipeSousaApp.domain.Instrutor;
import br.edu.infnet.FilipeSousaApp.service.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @PostMapping("/incluir")
    public ResponseEntity<Instrutor> incluir(@Valid @RequestBody InstrutorDTO instrutorDTO) {
        Instrutor criado = instrutorService.incluir(instrutorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> alterar(@PathVariable Integer id, @Valid @RequestBody InstrutorDTO instrutorDTO) {
        Instrutor atualizado = instrutorService.alterar(id, instrutorDTO);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/lista")
    public ResponseEntity<Collection<Instrutor>> obterLista() {
        Collection<Instrutor> lista = (Collection<Instrutor>) instrutorService.obterLista();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> obterPorId(@PathVariable Integer id) {
        return instrutorService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        instrutorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}