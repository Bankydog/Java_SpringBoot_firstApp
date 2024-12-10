package com.mergency.projectabz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mergency.projectabz.models.Personnel;
import com.mergency.projectabz.services.PersonnelService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

}
