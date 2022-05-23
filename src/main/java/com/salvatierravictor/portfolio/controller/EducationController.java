package com.salvatierravictor.portfolio.controller;

import com.salvatierravictor.portfolio.dto.EducationDTO;
import com.salvatierravictor.portfolio.dto.SkillsDTO;
import com.salvatierravictor.portfolio.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("education")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EducationController {

    @Autowired
    private EducationService educationService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<EducationDTO> save(@RequestBody EducationDTO educationDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(educationService.save(educationDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<EducationDTO> getEducation(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(educationService.getByIdEducation(id));
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<EducationDTO> editEducation(@Valid @PathVariable Long id, @Valid @RequestBody EducationDTO edit){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(educationService.editByIdEducation(id, edit));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        educationService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
