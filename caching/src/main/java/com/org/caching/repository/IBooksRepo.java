package com.org.caching.repository;

import com.org.caching.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBooksRepo extends JpaRepository<Books, Long> {

    Optional<Books> findByAuthorName(String authorName);
    Optional<Books> findByBookName(String bookName);
}
