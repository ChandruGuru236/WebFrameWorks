package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.ChandruGuruLanguage;
import com.example.day5cw3.repository.ChandruGuruLanguageRepo;

@Service
public class ChandruGuruLanguageService {
    private ChandruGuruLanguageRepo languageRepo;
    public ChandruGuruLanguageService(ChandruGuruLanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(ChandruGuruLanguage language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<ChandruGuruLanguage> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,ChandruGuruLanguage language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public ChandruGuruLanguage getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}
