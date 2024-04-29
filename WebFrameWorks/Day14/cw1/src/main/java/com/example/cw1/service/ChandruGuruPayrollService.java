package com.example.cw1.service;

import com.example.cw1.model.ChandruGuruPayroll;
import com.example.cw1.repository.ChandruGuruPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class ChandruGuruPayrollService {
    private final ChandruGuruPayrollRepo payrollRepo;

    public ChandruGuruPayrollService(ChandruGuruPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public ChandruGuruPayroll createPayroll(ChandruGuruPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public ChandruGuruPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}
