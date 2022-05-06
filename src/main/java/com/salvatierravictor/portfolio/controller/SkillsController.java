package com.salvatierravictor.portfolio.controller;

import com.salvatierravictor.portfolio.dto.SkillsDTO;
import com.salvatierravictor.portfolio.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<SkillsDTO> save(@Valid @RequestBody SkillsDTO skillsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(skillsService.save(skillsDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<SkillsDTO> getSkills(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(skillsService.getByIdSkills(id));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        skillsService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<SkillsDTO> editSkills(@Valid @PathVariable Long id, @Valid @RequestBody SkillsDTO edit){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(skillsService.editByIdSkills(id, edit));
    }
}
