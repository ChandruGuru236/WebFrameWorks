package com.example.ce1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.ChandruGuruEmployee;
import com.example.ce1.repository.ChandruGuruEmployeeRepo;

@Service
public class ChandruGuruEmployeeService {
    @Autowired
    ChandruGuruEmployeeRepo employeeRepo;

    @SuppressWarnings("null")
    public ChandruGuruEmployee setEmployee(ChandruGuruEmployee employee)
    {
        return employeeRepo.save(employee);
    }

    public List<ChandruGuruEmployee> getInnerEmployee()
    {
        return employeeRepo.getByInnerEmployees();
    }

    public List<ChandruGuruEmployee> getLeftOuterEmployee()
    {
        return employeeRepo.getByLeftOuterEmployees();
    }
}
