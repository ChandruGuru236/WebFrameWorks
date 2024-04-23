package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.ChandruGuruPerson;
import com.example.springapp.servicChandruGuruChandruGuruPerson;
import com.example.springapp.service.ChandruGuruPersonService;

@RestController
public class ChandruGuruPersonController {
    @Autowired
    private ChandruGuruPersonService ser;

    @PostMapping("/person")
    public ResponseEntity<Person> post(@RequestBody ChandruGuruChandruGuruPerson person) {
        if (ser.post(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/findByLastnameNot")
    public ResponseEntity<List<ChandruGuruChandruGuruPerson>> getAll(@RequestParam String lastname) {
        List<ChandruGuruChandruGuruPerson> li = ser.start(lastname);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/findByAgeNotIn")
    public ResponseEntity<List<ChandruGuruChandruGuruPersonus.NOT_FOUND);
        }
    }

    @GetMapping("/api/person/byAge")
    public ResponseEntity<List<ChandruGuruPerson>> getbyAge(@RequestParam int age)
    {
        List<ChandruGuruPerson> li = ser.getbyAge(age);
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
