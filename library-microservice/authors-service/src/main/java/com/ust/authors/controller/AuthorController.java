package com.ust.authors.controller;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import com.ust.authors.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // POST /authors
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(author));
    }

    // GET  /authors/{name}
    @GetMapping("/{name}")
    public ResponseEntity<Author> getByName(@PathVariable String author){
        var optional = authorService.findByName(author);
//        var optional = authorService.getAllAuthors();
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }
    /*@GetMapping("/{allAuthors}")
    public ResponseEntity<Author> getByName(@PathVariable String author){
//        var optional = authorService.findByName(author);
        var optional = authorService.getAllAuthors();
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
//        return ResponseEntity.ok(optional.get());
        return ResponseEntity.ok().build();
    }*/

    // GET  /authors/{name}/books
    @GetMapping("/{name}/books")
    public ResponseEntity<List<Book>> getBooksOfAuthor(@PathVariable String name){
        var list = authorService.findBooksByAuthor(name);
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

}
