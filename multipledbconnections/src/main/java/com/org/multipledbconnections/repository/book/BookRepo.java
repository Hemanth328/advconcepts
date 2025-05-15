package com.org.multipledbconnections.repository.book;

import com.org.multipledbconnections.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepo extends JpaRepository<Book, Integer> {
}
