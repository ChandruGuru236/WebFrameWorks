package com.example.day4cw2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw2.model.ChandruGuruJob;
import com.example.day4cw2.repository.ChandruGuruJobRepo;

@Service
public class ChandruGuruJobService {
    public ChandruGuruJobRepo jobRepo;
    public ChandruGuruJobService(ChandruGuruJobRepo jobRepo)
    {
        this.jobRepo = jobRepo;
    }
    public boolean saveJob(ChandruGuruJob job)
    {
        try{
            jobRepo.save(job);
        } 
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<ChandruGuruJob> getJobs()
    {
        return jobRepo.findAll();
    }
    public ChandruGuruJob getJobById(int id)
    {
        Optional<ChandruGuruJob> obj = jobRepo.findById(id);
        return obj.orElse(null);
    }
}
