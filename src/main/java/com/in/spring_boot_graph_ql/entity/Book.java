package com.in.spring_boot_graph_ql.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String publisher;
    @ManyToOne
    Author author;

    public Book(Long id, String title, String publisher, Author author) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author=author;
    }
    public Book(String title, String publisher, Author author) {
        this.title = title;
        this.publisher = publisher;
        this.author=author;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
