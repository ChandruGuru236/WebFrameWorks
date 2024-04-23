package com.example.day6pah.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6pah.model.ChandruGuruLanguage;
import com.example.day6pah.service.ChandruGuruLangaugeService;

@RestController
public class ChandruGuruLanguageController {
    public ChandruGuruLangaugeService langaugeService;
    public ChandruGuruLanguageController(ChandruGuruLangaugeService langaugeService)
    {
        this.langaugeService = langaugeService;
    }
     @PostMapping("/api/language")
    public ResponseEntity<ChandruGuruLanguage> postMethodName(@RequestBody ChandruGuruLanguage language) {
        if(langaugeService.postLanguage(language))
        {
            return new ResponseEntity<>(language,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/language/sortBy/{field}")
    public ResponseEntity<List<ChandruGuruLanguage>> getMethodName(@PathVariable("field") String field) {
        List<ChandruGuruLanguage> list = langaugeService.getSortedLanguages(field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/language/{offset}/{pagesize}")
    public ResponseEntity<List<ChandruGuruLanguage>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<ChandruGuruLanguage> list = langaugeService.getPaginationLanguages(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/api/language/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<ChandruGuruLanguage>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<ChandruGuruLanguage> list = langaugeService.getSortedPaginationLanguages(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}
