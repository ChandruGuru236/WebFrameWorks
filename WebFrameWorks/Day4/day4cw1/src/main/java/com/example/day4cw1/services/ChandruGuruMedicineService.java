package com.example.day4cw1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw1.model.ChandruGuruMedicine;
import com.example.day4cw1.repository.ChandruGuruMedicineRepo;

@Service
public class ChandruGuruMedicineService {
    public ChandruGuruMedicineRepo medicineRepo;
    public ChandruGuruMedicineService(ChandruGuruMedicineRepo medicineRepo)
    {
        this.medicineRepo = medicineRepo;
    }
    public boolean saveMedicine(ChandruGuruMedicine medicine)
    {
        try{
            medicineRepo.save(medicine);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<ChandruGuruMedicine> getMedicines()
    {
        return medicineRepo.findAll();
    }

    public ChandruGuruMedicine MedicineById(int id)
    {
        Optional<ChandruGuruMedicine> obj = medicineRepo.findById(id);
        return obj.orElse(new ChandruGuruMedicine());
    }

}
