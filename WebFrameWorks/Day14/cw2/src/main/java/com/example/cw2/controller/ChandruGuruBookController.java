package com.example.cw2.controller;

import com.example.cw2.model.ChandruGuruBook;
import com.example.cw2.service.ChandruGuruBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class ChandruGuruBookController {
    private final ChandruGuruBookService bookService;

    public ChandruGuruBookController(ChandruGuruBookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<ChandruGuruBook> createBook(@RequestBody ChandruGuruBook Book) {
        ChandruGuruBook createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<ChandruGuruBook>> getAllBooks() {
        List<ChandruGuruBook> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public ChandruGuruBook updateBookById(@PathVariable Long bookId,@RequestBody ChandruGuruBook book){
        ChandruGuruBook b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public ChandruGuruBook getBookById(@PathVariable Long bookId) {
        ChandruGuruBook book = bookService.getBookById(bookId);
        return book;
    }
}
