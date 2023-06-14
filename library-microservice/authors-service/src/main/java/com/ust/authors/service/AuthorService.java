package com.ust.authors.service;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Book> findBooksByAuthor(String author);

    Author create(Author author);
//    List<Author> getAllAuthors();

    Optional<Author> findByName(String name);
}
