package com.mergency.projectabz.services;

import java.lang.foreign.Linker.Option;
import java.util.*;

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

    public List<Personnel> getAllData() {
        return personnelRepository.findAll();
    }

    public Optional<Personnel> getPersonnelByID(Long id) {
        return personnelRepository.findById(id);
    }

    public Optional<Personnel> updatePersonnel(Long id, Personnel personnel) {
        Optional<Personnel> getPerson = personnelRepository.findById(id);
        if (getPerson.isPresent()) {
            Personnel result = getPerson.get();
            if (personnel.getFirstname() != null) {
                result.setFirstname(personnel.getFirstname());
            }
            if (personnel.getLastname() != null) {
                result.setLastname(personnel.getLastname());
            }
            return Optional.of(personnelRepository.save(result));
        }
        return Optional.empty();
    }

    public boolean deletePersonnelById(Long id) {
        Optional<Personnel> personnel = personnelRepository.findById(id);

        if (personnel.isPresent()) {
            personnelRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
