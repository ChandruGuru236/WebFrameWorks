package com.example.relation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.relation.model.ChandruGuruStudent;
import com.example.relation.service.ChandruGuruStudentService;
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
    @PostMapping("/api/student")
    public ChandruGuruStudent postMethodName(@RequestBody ChandruGuruStudent student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/api/student")
    public List<ChandruGuruStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}
