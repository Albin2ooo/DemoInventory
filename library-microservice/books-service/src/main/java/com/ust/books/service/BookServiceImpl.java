package com.ust.books.service;

import com.ust.books.domain.Book;
import com.ust.books.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private static List<Book> books;
    @Autowired
    private  BookRepo bookRepo;


    public BookServiceImpl() {
        books = new ArrayList<>();
    }

    @Override
    public List<Book> findBooksOfAuthor(String author) {
//        return books.stream().filter(b -> b.getAuthor().equals(author)).toList();
        return bookRepo.findBooksByAuthor(author);
    }

    @Override
    public Book create(Book book) {

        return bookRepo.save(book);
    }

    @Override
    public Optional<Book> findbyTitle(String title) {
//        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst();
        return bookRepo.findByTitle(title);
    }
}
