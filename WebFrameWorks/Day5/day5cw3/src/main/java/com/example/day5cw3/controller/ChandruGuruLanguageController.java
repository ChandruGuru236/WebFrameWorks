package com.example.day5cw3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5cw3.model.ChandruGuruLanguage;
import com.example.day5cw3.service.ChandruGuruLanguageService;

@RestController
public class ChandruGuruLanguageController {
    public ChandruGuruLanguageService languageService;
    public ChandruGuruLanguageController(ChandruGuruLanguageService languageService)
    {
        this.languageService=languageService;
    }
    @PostMapping("/language")
    public ResponseEntity<ChandruGuruLanguage> postMethodName(@RequestBody ChandruGuruLanguage language) {
        
        if(languageService.saveLanguage(language)==true)
        {
            return new ResponseEntity<>(language,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/language")
    public ResponseEntity<List<ChandruGuruLanguage>> getMethodName() {
        List<ChandruGuruLanguage> list =  languageService.getLanguages();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/language/{languageId}")
    public ResponseEntity<ChandruGuruLanguage> getlangauge(@PathVariable("languageId") int id) {
        ChandruGuruLanguage l =  languageService.getLanguageById(id);
        if(l == null)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(l,HttpStatus.OK);
    }
    
    @PutMapping("/language/{languageId}")
    public ResponseEntity<ChandruGuruLanguage> putMethodName(@PathVariable int id, @RequestBody ChandruGuruLanguage language) {
        if(languageService.updateLanguage(id,language) == true)
        {
            return new ResponseEntity<>(language,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @DeleteMapping("/language/{languageId}")
    public ResponseEntity<ChandruGuruLanguage> delete(@PathVariable("languageId") int id)
    {
        if(languageService.deleteLanguage(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
