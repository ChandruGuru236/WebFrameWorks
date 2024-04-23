package com.example.bidirection.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.bidirection.model.ChandruGuruStudent;
import com.example.bidirection.model.ChandruGuruStudent;
import com.example.bidirection.service.ChandruGuruStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ChandruGuruStudentController {
    public ChandruGuruStudentService studentService;
    public ChandruGuruStudentController(ChandruGuruStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/poststudent")
    public ChandruGuruStudent postMethodName(@RequestBody ChandruGuruStudent student) {
        return studentService.saveStudent(student);
    }
    @PostMapping("/api/poststudentinfo")
    public ChandruGuruStudentInfo postMethodName(@RequestBody ChandruGuruStudentInfo studentInfo) {
        return studentService.saveStudentInfo(studentInfo);
    }
    @GetMapping("/api/student")
    public List<ChandruGuruStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}