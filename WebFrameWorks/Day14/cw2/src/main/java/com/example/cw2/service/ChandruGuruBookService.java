package com.example.cw2.service;

import com.example.cw2.model.ChandruGuruBook;
import com.example.cw2.repository.ChandruGuruBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChandruGuruBookService {
    private final ChandruGuruBookRepo bookRepo;

    public ChandruGuruBookService(ChandruGuruBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public ChandruGuruBook createBook(ChandruGuruBook Book) {
        return bookRepo.save(Book);
    }
    public List<ChandruGuruBook> getAllBooks() {
        return bookRepo.findAll();
    }
    public ChandruGuruBook getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public ChandruGuruBook updateBookById(Long id,ChandruGuruBook book){
        ChandruGuruBook b = bookRepo.findById(id).orElse(null);
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setAvailableCopies(book.getAvailableCopies());
            b.setTitle(book.getTitle());
            b.setTotalCopies(book.getTotalCopies());
            bookRepo.save(b);
        }
        return b;
    }
}
