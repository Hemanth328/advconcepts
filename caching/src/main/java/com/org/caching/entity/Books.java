package com.org.caching.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books", indexes = {
        @Index(name = "book_name_idx", columnList = "book_name"),
        @Index(name = "author_name_idx", columnList = "author_name", unique = true)
})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private String authorName;

    private float price;

    private int pages;
}
