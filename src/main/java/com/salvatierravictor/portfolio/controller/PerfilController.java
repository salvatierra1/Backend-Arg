package com.salvatierravictor.portfolio.controller;


import com.salvatierravictor.portfolio.dto.PerfilDTO;
import com.salvatierravictor.portfolio.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("perfil")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<PerfilDTO> save(@RequestBody PerfilDTO perfilDTO){
        PerfilDTO perfilSaved = perfilService.save(perfilDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilSaved);
    }

    //=== Get ===
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PerfilDTO getPerfil(@PathVariable Long id){
        return perfilService.getPerfil(id);
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        perfilService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> editPerfil(@PathVariable Long id, @RequestBody PerfilDTO edit){
        PerfilDTO perfilEditado = perfilService.editPerfil(id, edit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(perfilEditado);
    }
}
