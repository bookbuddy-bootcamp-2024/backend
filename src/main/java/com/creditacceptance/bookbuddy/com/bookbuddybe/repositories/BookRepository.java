package com.creditacceptance.bookbuddy.com.bookbuddybe.repositories;

import com.creditacceptance.bookbuddy.com.bookbuddybe.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
