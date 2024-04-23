package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.ChandruGuruDoor;
import com.example.springapp.repository.ChandruGuruDoorRepo;

@Service
public class ChandruGuruDoorService {
    @Autowired
    private ChandruGuruDoorRepo rep;

    public boolean post(ChandruGuruDoor door)
    {
        try
        {
            rep.save(door);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<ChandruGuruDoor> getAll()
    {
        return rep.findAll();
    }

    public List<ChandruGuruDoor> getbyDoorId(int doorId)
    {
        return rep.findByDoorId(doorId);
    }
    public List<ChandruGuruDoor> getbyType(String type)
    {
        return rep.findByAccessType(type);
    }
    
}
