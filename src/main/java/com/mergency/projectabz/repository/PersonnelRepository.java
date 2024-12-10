package com.mergency.projectabz.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mergency.projectabz.models.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}
