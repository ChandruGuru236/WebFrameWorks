package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.ChandruGuruPerson;
import com.example.springapp.repository.ChandruGuruPersonRepo;

@Service
public class ChandruGuruPersonService {
    @Autowired
    private ChandruGuruPersonRepo rep;

    public boolean post(ChandruGuruPerson person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<ChandruGuruPerson> start(String lastname)
    {
        return rep.findByLastnameNot(lastname);
    }

    public List<ChandruGuruPerson> end(List<Integer> ages)
    {
        return rep.findByAgeNotIn(ages);
    }
    
}
