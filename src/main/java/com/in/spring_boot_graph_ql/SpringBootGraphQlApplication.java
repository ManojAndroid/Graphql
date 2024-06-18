package com.in.spring_boot_graph_ql;

import com.in.spring_boot_graph_ql.entity.Author;
import com.in.spring_boot_graph_ql.entity.Book;
import com.in.spring_boot_graph_ql.repository.AuthorRepository;
import com.in.spring_boot_graph_ql.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

@SpringBootApplication
public class SpringBootGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphQlApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            Author manoj = authorRepository.save(new Author(null, "manoj"));
            Author akash = authorRepository.save(new Author(null, "akash"));
            System.out.println("   maoj" + manoj);
            bookRepository.saveAll(List.of(new Book(null, "Spring", "spring1", manoj),
                    new Book(null, "Java", "javatest", akash),
                    new Book(null, "Hibernate", "Hibernate test", manoj)));

        };
    }

}
