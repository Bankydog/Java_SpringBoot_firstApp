package com.mergency.projectabz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mergency.projectabz.models.Personnel;
import com.mergency.projectabz.services.PersonnelService;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/api")
public class PersonnelController {

    private PersonnelService personnelService;

    @Autowired
    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/post/personnel")
    public ResponseEntity<Personnel> postPersonnel(@RequestBody Personnel personnel) {
        Personnel savedPersonnel = personnelService.createPersonnel(personnel);
        return new ResponseEntity<>(savedPersonnel, HttpStatus.CREATED);
    }

    @GetMapping("/get/personnel")
    public ResponseEntity<List<Personnel>> getAllPersonnel() {
        List<Personnel> result = personnelService.getAllData();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get/personnel/{id}")
    public ResponseEntity<?> getPersonnelById(@PathVariable Long id) {
        Optional<Personnel> result = personnelService.getPersonnelByID(id);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Personnel with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put/personnel/{id}")
    public ResponseEntity<?> putPersonnelById(@PathVariable Long id, @RequestBody Personnel personnel) {
        Optional<Personnel> result = personnelService.updatePersonnel(id, personnel);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Personnel with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/personnel/{id}")
    public ResponseEntity<String> deletePersonnel(@PathVariable Long id) {
        boolean isDeleted = personnelService.deletePersonnelById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Personnel with ID " + id + " was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Personnel with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

}
