package com.org.caching.service;

import com.org.caching.entity.Books;
import com.org.caching.exception.NoBookFoundException;
import com.org.caching.repository.IBooksRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private IBooksRepo booksRepo;

    public BookServiceImpl(IBooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }
    @Override
    public Books addBook(Books book) {
        logger.info("Adding book record for book: {} {}", book.getBookName(), "From Service");
        return booksRepo.save(book);
    }

    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Books getBookById(Long id) {
        logger.info("Fetching book record for id: {} {}", id, "From Service");
        return booksRepo.findById(id).orElseThrow(() -> new NoBookFoundException("No book found for id: " + id));
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public void deleteBook(Long id) {
        if(booksRepo.existsById(id)) {
            logger.info("Deleting book record for id: {} {}", id, "From Service");
            booksRepo.deleteById(id);
        } else {
            throw new NoBookFoundException("No book found for id: " + id);
        }
    }

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Books updateBook(Books book) {
        logger.info("Updating book record for book: {} {}", book.getBookName(), "From Service");
        if(booksRepo.existsById(book.getId())) {
            return booksRepo.save(book);
        }else {
            throw new NoBookFoundException("No book found for id: " + book.getId());
        }
    }

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Books partialUpdateBook(Books book) {
        logger.info("Partial updating book record for book: {} {}", book.getBookName(), "From Service");
        if(booksRepo.existsById(book.getId())) {
            Books existingBook = booksRepo.findById(book.getId()).get();
            existingBook.setBookName(book.getBookName());
            existingBook.setAuthorName(book.getAuthorName());
            existingBook.setPrice(book.getPrice());
            existingBook.setPages(book.getPages());
            return booksRepo.save(existingBook);
        } else {
            throw new NoBookFoundException("No book found for id: " + book.getId());
        }
    }
}
