package com.example.day4cw2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4cw2.model.ChandruGuruJob;
import com.example.day4cw2.services.ChandruGuruJobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ChandruGuruJobController {
    public ChandruGuruJobService jobService;
    public ChandruGuruJobController(ChandruGuruJobService jobService)
    {
        this.jobService = jobService;
    }
    @PostMapping("/api/job")
    public ResponseEntity<ChandruGuruJob> postMethodName(@RequestBody ChandruGuruJob job) {
        if(jobService.saveJob(job)==true)
        {
            return new ResponseEntity<>(job,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/job")
    public ResponseEntity<List<ChandruGuruJob>> getMethodName() {
        List<ChandruGuruJob> j =  jobService.getJobs();
        if(j.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(j,HttpStatus.OK);
    }

    @GetMapping("/api/job/{jobId}")
    public ResponseEntity<ChandruGuruJob> jobId(@PathVariable("jobId") int id) {
        ChandruGuruJob j = jobService.getJobById(id);
        if(j==null)
        {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(j,HttpStatus.OK);
    }
    
    
    
}
