package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.ChandruGuruPerson;
import com.example.springapp.model.ChandruGuruPerson;
import java.util.List;


@Repository
public interface ChandruGuruPersonRepo extends JpaRepository<ChandruGuruPerson,Integer>{

    List<ChandruGuruPerson> findByLastnameNot(String lastname);
    List<ChandruGuruPerson> findByAgeNotIn(List<Integer> ages);
    
}
