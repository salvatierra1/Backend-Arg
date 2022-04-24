package com.salvatierravictor.portfolio.controller;

import com.salvatierravictor.portfolio.dto.EducacionDTO;
import com.salvatierravictor.portfolio.dto.PerfilDTO;
import com.salvatierravictor.portfolio.service.EducacionService;
import com.salvatierravictor.portfolio.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<EducacionDTO> save(@RequestBody EducacionDTO educacionDTO){

        EducacionDTO educacionGuardado = educacionService.save(educacionDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(educacionGuardado);

    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<EducacionDTO> getEducacion(@PathVariable Long id){
        EducacionDTO educacionDTO = educacionService.getEducacion(id);
        return ResponseEntity.status(HttpStatus.OK).body(educacionDTO);
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        educacionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
