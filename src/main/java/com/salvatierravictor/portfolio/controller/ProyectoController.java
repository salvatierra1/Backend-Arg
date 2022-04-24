package com.salvatierravictor.portfolio.controller;
import com.salvatierravictor.portfolio.dto.ProyectoDTO;
import com.salvatierravictor.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<ProyectoDTO> save(@RequestBody ProyectoDTO proyectoDTO){
        ProyectoDTO proyectoGuardado = proyectoService.save(proyectoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(proyectoGuardado);
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> getProyecto(@PathVariable Long id){
        ProyectoDTO proyectoDTO = proyectoService.getProyecto(id);
        return ResponseEntity.status(HttpStatus.OK).body(proyectoDTO);
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        proyectoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
