package com.example.bidirection.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bidirection.model.Student;
import com.example.bidirection.model.StudentInfo;
import com.example.bidirection.repository.StudentInfoRepository;
import com.example.bidirection.repository.StudentRepository;

@Service
public class ChandruGuruStudentService {
    public ChandruGuruStudentRepository studentRepository;
    public ChandruGuruStudentInfoRepository studentInfoRepository;
    public ChandruGuruStudentService(ChandruGuruStudentRepository studentRepository,ChandruGuruStudentInfoRepository studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public ChandruGuruStudent saveStudent(ChandruGuruStudent student)
    {
        return studentRepository.save(student);
    }
    public ChandruGuruStudentInfo saveStudentInfo(ChandruGuruStudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<ChandruGuruStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
