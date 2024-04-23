package com.example.day4cw1.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw1.model.ChandruGuruMedicine;
import com.example.day4cw1.services.ChandruGuruMedicineService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ChandruGuruMedicineController {

    private ChandruGuruMedicineService medicineService;

    public ChandruGuruMedicineController(ChandruGuruMedicineService medicineService)
    {
        this.medicineService = medicineService;
    }
    @PostMapping("/api/medicine")
    public ResponseEntity<ChandruGuruMedicine> postMethodName(@RequestBody ChandruGuruMedicine medicine) {
        
        if(medicineService.saveMedicine(medicine)==false)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medicine,HttpStatus.CREATED);
    }

    @GetMapping("/api/medicines")
    public ResponseEntity<List<ChandruGuruMedicine>> getMethodName() {
        List<ChandruGuruMedicine> list = medicineService.getMedicines();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/medicine/{medicineId}")
    public ResponseEntity<ChandruGuruMedicine> getMedicineById(@PathVariable("medicineId") int id) {
        ChandruGuruMedicine m =  medicineService.MedicineById(id);
        if(m==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    
    
}
