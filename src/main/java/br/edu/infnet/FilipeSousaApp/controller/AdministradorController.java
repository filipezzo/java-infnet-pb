package br.edu.infnet.FilipeSousaApp.controller;

import br.edu.infnet.FilipeSousaApp.domain.Administrador;
import br.edu.infnet.FilipeSousaApp.dto.AdministradorDTO;
import br.edu.infnet.FilipeSousaApp.service.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/lista")
    public ResponseEntity<Collection<Administrador>> obterLista() {
        Collection<Administrador> lista = (Collection<Administrador>) administradorService.obterLista();
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> obterPorId(@PathVariable Integer id) {
        return administradorService.obterPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/incluir")
    public ResponseEntity<Administrador> incluir(@Valid @RequestBody AdministradorDTO adminDTO) {
        Administrador criado = administradorService.incluir(adminDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> alterar(@PathVariable Integer id, @Valid @RequestBody AdministradorDTO adminDTO) {
        Administrador atualizado = administradorService.alterar(id, adminDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        if (administradorService.obterPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        administradorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}