package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.ChandruGuruEmployee;
import com.example.ce1.service.ChandruGuruEmployeeService;

@RestController
public class ChandruGuruEmployeeController {
    @Autowired
    ChandruGuruEmployeeService employeeService;

    @PostMapping("/employee")
    public ChandruGuruEmployee setMethod(@RequestBody ChandruGuruEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<ChandruGuruEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<ChandruGuruEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}
