package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.ChandruGuruStudentDetail;
import com.example.springapp.repository.ChandruGuruStudentDetailRepository;
import com.example.springapp.repository.ChandruGuruStudentRepository;

@Service
public class ChandruGuruStudentDetailService {
    @Autowired
    ChandruGuruStudentDetailRepository studentDetailRepository;
    @Autowired
    ChandruGuruStudentRepository studentRepository;
    public ChandruGuruStudentDetail addStudentDetail(int id,ChandruGuruStudentDetail studentDetail)
    {
        if(studentRepository.existsById(id))
        {
            studentDetailRepository.addStudentDetail(studentDetail.getAddress(),studentDetail.getPhoneNumber(),id);
            return studentDetail;
        }
        else
        return null;
    }
    
    
}
