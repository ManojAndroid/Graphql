package com.in.spring_boot_graph_ql.repository;

import com.in.spring_boot_graph_ql.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
