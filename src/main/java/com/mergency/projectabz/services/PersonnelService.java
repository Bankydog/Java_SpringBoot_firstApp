package com.mergency.projectabz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mergency.projectabz.models.Personnel;
import com.mergency.projectabz.repository.PersonnelRepository;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    public Personnel createPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }
}
