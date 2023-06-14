package com.ust.books.controller;

import com.ust.books.domain.Book;
import com.ust.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        var createdBook = bookService.create(book);
        return ResponseEntity.status(201).body(createdBook);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable String title) {
        var book = bookService.findbyTitle(title);
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book.get());
    }

    @GetMapping("/s/{author}")
    public ResponseEntity<List<Book>> getBooksOfAuthor(@PathVariable String author) {
        var list = bookService.findBooksOfAuthor(author);
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }
}
