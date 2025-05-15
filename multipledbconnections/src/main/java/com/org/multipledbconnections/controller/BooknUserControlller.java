package com.org.multipledbconnections.controller;

import com.org.multipledbconnections.model.book.Book;
import com.org.multipledbconnections.model.user.User;
import com.org.multipledbconnections.service.BooknUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooknUserControlller {

    private final BooknUserService booknUserService;

    public BooknUserControlller(BooknUserService booknUserService) {
        this.booknUserService = booknUserService;
    }

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(booknUserService.saveBook(book));
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(booknUserService.saveUser(user));
    }
}
