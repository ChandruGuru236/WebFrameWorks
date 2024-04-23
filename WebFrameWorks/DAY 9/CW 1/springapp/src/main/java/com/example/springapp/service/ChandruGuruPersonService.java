package com.example.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.ChandruGuruPerson;
import com.example.springapp.repository.ChandruGuruPersonRepo;

@Service
public class ChandruGuruPersonService {
    public ChandruGuruPersonRepo personRepo;

    public PersonService(ChandruGuruPersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public boolean savePerson(ChandruGuruPerson person) {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<ChandruGuruPerson> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}
