package com.in.spring_boot_graph_ql.controller;

import com.in.spring_boot_graph_ql.client.WebClientHelper;
import com.in.spring_boot_graph_ql.entity.Author;
import com.in.spring_boot_graph_ql.entity.Book;
import com.in.spring_boot_graph_ql.repository.AuthorRepository;
import com.in.spring_boot_graph_ql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthorController {
    //https://www.bing.com/videos/riverview/relatedvideo?&q=graphql+with+spring+boot&&mid=C08C8F5D8221A3E012B3C08C8F5D8221A3E012B3&&FORM=VRDGAR

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private WebClientHelper webClientHelper;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository, WebClientHelper webClientHelper) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.webClientHelper = webClientHelper;
    }

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Long id) {
        webClientHelper.fetch();
        return authorRepository.findById(id);
    }


    /*  @MutationMapping
      Book addBook(@Argument BookInput book) {
          Author author = authorRepository.findById(book.authorId).orElseThrow(() -> new RuntimeException("Author not present for id :" + book.authorId));
          Book b = new Book(book.title, book.publisher, author);
          return bookRepository.save(b);
      }

      record BookInput(String title, String publisher, Long authorId) {
      }*/
    @SchemaMapping(typeName = "Mutation", field = "addBook")
    Book addBook(@Argument BookInput book) {
        Author author = authorRepository.findById(book.authorId).orElseThrow(() -> new RuntimeException("Author not present for id :" + book.authorId));
        Book b = new Book(book.title, book.publisher, author);
        return bookRepository.save(b);
    }

    record BookInput(String title, String publisher, Long authorId) {
    }
}
