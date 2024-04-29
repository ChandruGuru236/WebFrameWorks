package com.example.cw1.service;

import com.example.cw1.model.ChandruGuruEmployee;
import com.example.cw1.repository.ChandruGuruEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChandruGuruEmployeeService {
    private final ChandruGuruEmployeeRepo employeeRepo;

    public ChandruGuruEmployeeService(ChandruGuruEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public ChandruGuruEmployee createEmployee(ChandruGuruEmployee employee) {
        return employeeRepo.save(employee);
    }

    public List<ChandruGuruEmployee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<ChandruGuruEmployee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}
