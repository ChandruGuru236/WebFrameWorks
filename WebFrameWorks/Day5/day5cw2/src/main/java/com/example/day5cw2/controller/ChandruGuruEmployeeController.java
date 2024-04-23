package com.example.day5cw2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5cw2.model.ChandruGuruEmployee;
import com.example.day5cw2.service.ChandruGuruEmployeeService;

@RestController
public class ChandruGuruEmployeeController {
    public ChandruGuruEmployeeService employeeService;
    public ChandruGuruEmployeeController( ChandruGuruEmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @PostMapping("/api/employee")
    public ResponseEntity<ChandruGuruEmployee> postMethodName(@RequestBody ChandruGuruEmployee employee) {
        if(employeeService.saveEmployee(employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/api/employee/{employeeId}")
    public ResponseEntity<ChandruGuruEmployee> putMethodName(@PathVariable("employeeId") int id, @RequestBody ChandruGuruEmployee employee) {
        if(employeeService.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/api/employee/{employeeId}")
    public ResponseEntity<ChandruGuruEmployee> delete(@PathVariable("employeeId") int id,@RequestBody ChandruGuruEmployee employee)
    {
        if(employeeService.deleteEmployee(id) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
