package com.example.ce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.ChandruGuruAddress;
import com.example.ce1.repository.ChandruGuruAddressRepo;
import com.example.ce1.repository.ChandruGuruEmployeeRepo;

@Service
public class ChandruGuruAddressService {
    @Autowired
    ChandruGuruAddressRepo addressRepo;
    @Autowired
    ChandruGuruEmployeeRepo employeeRepo;
    public ChandruGuruAddress setAddressById(int id,ChandruGuruAddress address)
    {
        if(employeeRepo.existsById(id))
        {
            addressRepo.setByemployeeId(address.getCity(), address.getStreet(), id);
            return address;
        }
        else
        {
            return null;
        }
    }
}
