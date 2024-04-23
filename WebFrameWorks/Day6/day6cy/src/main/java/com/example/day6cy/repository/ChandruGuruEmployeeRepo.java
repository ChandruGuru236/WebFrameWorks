package com.example.day6cy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6cy.model.ChandruGuruEmployee;

public interface ChandruGuruEmployeeRepo extends JpaRepository<ChandruGuruEmployee,Integer>{
    
}
