package com.org.caching.service;

import com.org.caching.entity.Books;

public interface IBookService {

    Books addBook(Books book);

    Books getBookById(Long id);

    void deleteBook(Long id);

    Books updateBook(Books book);

    Books partialUpdateBook(Books book);
}
