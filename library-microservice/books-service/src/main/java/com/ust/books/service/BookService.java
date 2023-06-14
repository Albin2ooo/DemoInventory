package com.ust.books.service;

import com.ust.books.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findBooksOfAuthor(String author);

    Book create(Book book);

    Optional<Book> findbyTitle(String title);
}
