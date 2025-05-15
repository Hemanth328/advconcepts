package com.org.caching.controller;

import com.org.caching.entity.Books;
import com.org.caching.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

    private final IBookService bookService;

    public BooksController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<Books> createBookRecord(@RequestBody Books book) {
        logger.info("Creating book record for book: {}", book.getBookName());
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Long id) {
        logger.info("Fetching book record for id: {}", id);
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Books> updateBook(@RequestBody Books book) {
        logger.info("Updating book record for book: {}", book.getBookName());
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @PatchMapping("/partial-update")
    public ResponseEntity<Books> partialUpdateBook(@RequestBody Books book) {
        logger.info("Partial updating book record for book: {}", book.getBookName());
        return ResponseEntity.ok(bookService.partialUpdateBook(book));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        logger.info("Deleting book record for id: {}", id);
        bookService.deleteBook(id);
    }
}
