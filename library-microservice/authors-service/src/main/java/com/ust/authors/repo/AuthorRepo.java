package com.ust.authors.repo;

import com.ust.authors.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
