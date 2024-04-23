package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.ChandruGuruEmployee;
import com.example.day5cw2.repository.ChandruGuruEmployeeRepo;

@Service
public class ChandruGuruEmployeeService {
    public ChandruGuruEmployeeRepo employeeRepo;
    public ChandruGuruEmployeeService(ChandruGuruEmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(ChandruGuruEmployee employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,ChandruGuruEmployee employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public ChandruGuruEmployee getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}
