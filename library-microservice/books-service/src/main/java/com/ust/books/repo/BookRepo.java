package com.ust.books.repo;

import com.ust.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Integer> {
    public Optional<Book> findByTitle(String title);
    public List<Book> findBooksByAuthor(String author);
}
