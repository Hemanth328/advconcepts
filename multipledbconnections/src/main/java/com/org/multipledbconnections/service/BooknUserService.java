package com.org.multipledbconnections.service;

import com.org.multipledbconnections.model.book.Book;
import com.org.multipledbconnections.model.user.User;
import com.org.multipledbconnections.repository.book.BookRepo;
import com.org.multipledbconnections.repository.user.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class BooknUserService {

    private final BookRepo bookRepo;

    private final UserRepo userRepo;

    public BooknUserService(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
