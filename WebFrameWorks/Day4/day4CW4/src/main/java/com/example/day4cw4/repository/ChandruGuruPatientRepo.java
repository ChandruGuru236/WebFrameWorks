package com.example.day4cw4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day4cw4.model.ChandruGuruPatient;

@Repository
public interface ChandruGuruPatientRepo<S> extends JpaRepository<ChandruGuruPatient,Integer>{

    @SuppressWarnings("null")
    <S> save(ChandruGuruPatient patient);

    List<ChandruGuruPatient> findAll();

    Optional<ChandruGuruPatient> findById(int id);
    
}
