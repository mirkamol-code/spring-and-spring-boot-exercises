package com.amigoscode.book;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;
import org.springframework.format.annotation.NumberFormat;

// TODO: 01 - Make this class a JPA entity by:
//  - Adding @Entity annotation
//  - Adding @Id and @GeneratedValue(strategy = GenerationType.IDENTITY) to the id field
//  - Adding a no-arg constructor (required by JPA)
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @Column(name = "published_year")
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
