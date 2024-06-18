package com.in.spring_boot_graph_ql.repository;

import com.in.spring_boot_graph_ql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
