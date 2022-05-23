package com.salvatierravictor.portfolio.controller;
import com.salvatierravictor.portfolio.dto.EducationDTO;
import com.salvatierravictor.portfolio.dto.ProjectDTO;
import com.salvatierravictor.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO projectDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(projectDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getByIdProject(id));
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> editProject(@Valid @PathVariable Long id, @Valid @RequestBody ProjectDTO edit){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(projectService.editByIdProject(id, edit));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        projectService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
