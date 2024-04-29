package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.ChandruGuruAuthor;
import com.example.q1.model.ChandruGuruBook;
import com.example.q1.repository.ChandruGuruAuthorRepository;
import com.example.q1.repository.ChandruGuruBookRepository;

@Service
public class ChandruGuruBookService {
    @Autowired
    private ChandruGuruBookRepository bookRepository;
@Autowired
private ChandruGuruAuthorRepository authorRepository;
    public ChandruGuruBook saveBook(Long authorId, ChandruGuruBook book) {
        ChandruGuruAuthor author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public ChandruGuruBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

