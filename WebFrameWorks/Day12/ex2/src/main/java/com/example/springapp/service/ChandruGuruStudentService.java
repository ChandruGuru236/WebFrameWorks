package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.ChandruGuruStudent;
import com.example.springapp.repository.ChandruGuruStudentRepository;

@Service
public class ChandruGuruStudentService {
    @Autowired
    ChandruGuruStudentRepository studentRepository;
    public ChandruGuruStudent addStudents(ChandruGuruStudent student)
    {
        return studentRepository.save(student);
    }
    public List<ChandruGuruStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<ChandruGuruStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<ChandruGuruStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}
