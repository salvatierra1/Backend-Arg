package com.salvatierravictor.portfolio.controller;

import com.salvatierravictor.portfolio.dto.AboutDTO;

import com.salvatierravictor.portfolio.dto.SkillsDTO;
import com.salvatierravictor.portfolio.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<AboutDTO> save(@RequestBody AboutDTO aboutDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(aboutService.save(aboutDTO));

    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<AboutDTO> getAbout(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(aboutService.getByIdAbout(id));
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<AboutDTO> editAbout(@Valid @PathVariable Long id, @Valid @RequestBody AboutDTO edit){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(aboutService.editByIdAbout(id, edit));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        aboutService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
