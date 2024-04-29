package com.example.cw1.controller;

import com.example.cw1.model.ChandruGuruEmployee;
import com.example.cw1.service.ChandruGuruEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class ChandruGuruEmployeeController {
    private final ChandruGuruEmployeeService employeeService;

    public ChandruGuruEmployeeController(ChandruGuruEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ChandruGuruEmployee> createEmployee(@RequestBody ChandruGuruEmployee employee) {
        ChandruGuruEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<ChandruGuruEmployee>> getAllEmployees() {
        List<ChandruGuruEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ChandruGuruEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<ChandruGuruEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

