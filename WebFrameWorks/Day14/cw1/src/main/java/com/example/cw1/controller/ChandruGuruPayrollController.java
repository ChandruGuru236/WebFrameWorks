package com.example.cw1.controller;

import com.example.cw1.model.ChandruGuruPayroll;
import com.example.cw1.service.ChandruGuruPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class ChandruGuruPayrollController {
    private final ChandruGuruPayrollService payrollService;

    public ChandruGuruPayrollController(ChandruGuruPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<ChandruGuruPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody ChandruGuruPayroll payroll) {
        ChandruGuruPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<ChandruGuruPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        ChandruGuruPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
