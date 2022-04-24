package com.salvatierravictor.portfolio.controller;

import com.salvatierravictor.portfolio.dto.AcercaDTO;

import com.salvatierravictor.portfolio.dto.EducacionDTO;
import com.salvatierravictor.portfolio.service.AcercaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acerca")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AcercaController {

    @Autowired
    private AcercaService acercaService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<AcercaDTO> save(@RequestBody AcercaDTO acercaDTO){

        AcercaDTO acercaGuardado = acercaService.save(acercaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(acercaGuardado);

    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<AcercaDTO> getAcerca(@PathVariable Long id){
        AcercaDTO acercaDTO = acercaService.getAcerca(id);
        return ResponseEntity.status(HttpStatus.OK).body(acercaDTO);
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        acercaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
