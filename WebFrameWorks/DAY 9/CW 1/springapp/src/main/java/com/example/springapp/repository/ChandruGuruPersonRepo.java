package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springapp.model.ChandruGuruPerson;

public interface ChandruGuruPersonRepo extends JpaRepository<ChandruGuruPerson, Integer> {
    @Query("SELECT p FROM Person p WHERE age=?1")
    List<ChandruGuruPerson> findByAge(int age);
}
