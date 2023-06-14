package com.ust.authors.service;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import com.ust.authors.repo.AuthorRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static List<Author> authors;
  /* private AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }*/

    private RestTemplate restTemplate;

    public AuthorServiceImpl(RestTemplate restTemplate) {
        authors = new ArrayList<>();
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        var response = restTemplate.getForEntity("http://books-service/books/{author}",
                Book[].class, author);
        if (response.hasBody()) {
            return Arrays.stream(response.getBody()).toList();
        }
        return List.of();
    }

    @Override
    public Author create(Author author) {
        authors.add(author);
//        authorRepo.save(author);
        return author;

    }
//    @Override
//    public List<Author> getAllAuthors(){
//        return (List<Author>) authorRepo.findAll();
//    }

    @Override
    public Optional<Author> findByName(String name) {
        return authors.stream().filter(a -> a.getName().equals(name)).findFirst();
//        return
    }
}
