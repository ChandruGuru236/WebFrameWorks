package com.example.day4cw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4cw2.model.ChandruGuruJob;

@Repository
public interface ChandruGuruJobRepo extends JpaRepository<ChandruGuruJob,Integer>{
    
}
