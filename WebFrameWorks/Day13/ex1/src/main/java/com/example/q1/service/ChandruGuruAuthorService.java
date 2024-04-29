package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.ChandruGuruAuthor;
import com.example.q1.repository.ChandruGuruAuthorRepository;

@Service
public class ChandruGuruAuthorService {
    @Autowired
    private ChandruGuruAuthorRepository authorRepository;

    public ChandruGuruAuthor saveAuthor(ChandruGuruAuthor author) {
        return authorRepository.save(author);
    }

    public ChandruGuruAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<ChandruGuruAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public ChandruGuruAuthor updateAuthor(Long id, ChandruGuruAuthor author) {
        ChandruGuruAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
