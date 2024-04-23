package com.example.day6cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day6cw1.model.ChandruGuruChildren;
import com.example.day6cw1.service.ChandruGuruChildrenService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class ChandruGuruChildrenController {
    public ChandruGuruChildrenService childrenService;
    public ChandruGuruChildrenController(ChandruGuruChildrenService childrenService)
    {
        this.childrenService = childrenService;
    }
    @PostMapping("/api/children")
    public ResponseEntity<ChandruGuruChildren> postMethodName(@RequestBody ChandruGuruChildren children) {
        if(childrenService.postChildren(children))
        {
            return new ResponseEntity<>(children,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<List<ChandruGuruChildren>> getMethodName(@PathVariable("field") String field) {
        List<ChandruGuruChildren> list = childrenService.getSortedChildrens(field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<List<ChandruGuruChildren>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<ChandruGuruChildren> list = childrenService.getPaginationChildrens(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<ChandruGuruChildren>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<ChandruGuruChildren> list = childrenService.getSortedPaginationChildrens(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}
