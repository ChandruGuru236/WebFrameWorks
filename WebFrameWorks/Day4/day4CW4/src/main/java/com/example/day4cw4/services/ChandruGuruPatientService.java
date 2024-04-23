package com.example.day4cw4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw4.model.ChandruGuruPatient;
import com.example.day4cw4.repository.ChandruGuruPatientRepo;

@Service
public class ChandruGuruPatientService {
    public ChandruGuruPatientRepo patientRepo;
    public ChandruGuruPatientService(ChandruGuruPatientRepo patientRepo)
    {
        this.patientRepo = patientRepo;
    }
    public boolean savePatient(ChandruGuruPatient patient)
    {
        try{
            patientRepo.save(patient);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<ChandruGuruPatient> getPatients()
    {
        return patientRepo.findAll();
    }
    public ChandruGuruPatient getPatientById(int id)
    {
        Optional<ChandruGuruPatient> obj = patientRepo.findById(id);
        return obj.orElse(null);
    }
}
