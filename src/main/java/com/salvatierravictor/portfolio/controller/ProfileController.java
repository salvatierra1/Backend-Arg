package com.salvatierravictor.portfolio.controller;


import com.salvatierravictor.portfolio.dto.ProfileCompleteDTO;
import com.salvatierravictor.portfolio.dto.ProfileDTO;
import com.salvatierravictor.portfolio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
@CrossOrigin(origins = "https://portfolio-8d6ba.web.app")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    //=== Post ===
    @PostMapping
    public ResponseEntity<ProfileDTO> save(@RequestBody ProfileDTO profileDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(profileService.save(profileDTO));
    }

    //=== Get ===
    @GetMapping("/{id}")
    public ResponseEntity<ProfileCompleteDTO> getProfile(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(profileService.getByIdProfile(id));
    }

    //=== Delete ===
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        profileService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //=== Put ===
    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> editProfile(@PathVariable Long id, @RequestBody ProfileDTO edit){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(profileService.editByIdProfile(id, edit));
    }
}
