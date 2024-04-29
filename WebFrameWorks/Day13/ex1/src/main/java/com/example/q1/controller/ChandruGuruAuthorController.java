package com.example.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.ChandruGuruAuthor;
import com.example.q1.model.ChandruGuruBook;
import com.example.q1.service.ChandruGuruAuthorService;
import com.example.q1.service.ChandruGuruBookService;

@RestController
public class ChandruGuruAuthorController {
    @Autowired
    private ChandruGuruAuthorService authorService;
@Autowired
private ChandruGuruBookService bookService;
    @PostMapping("/author")
    public ResponseEntity<ChandruGuruAuthor> createAuthor(@RequestBody ChandruGuruAuthor author) {
        ChandruGuruAuthor savedAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

    @PostMapping("/book/author/{authorId}")
    public ResponseEntity<ChandruGuruBook> createBookForAuthor(@PathVariable Long authorId, @RequestBody ChandruGuruBook book) {
        ChandruGuruBook savedBook = bookService.saveBook(authorId, book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<ChandruGuruAuthor> getAuthorById(@PathVariable Long authorId) {
        ChandruGuruAuthor author = authorService.getAuthorById(authorId);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/author")
    public ResponseEntity<List<ChandruGuruAuthor>> getAllAuthors() {
        List<ChandruGuruAuthor> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PutMapping("/author/{authorId}")
    public ResponseEntity<ChandruGuruAuthor> updateAuthor(@PathVariable Long authorId, @RequestBody ChandruGuruAuthor author) {
        ChandruGuruAuthor updatedAuthor = authorService.updateAuthor(authorId, author);
        if (updatedAuthor != null) {
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
