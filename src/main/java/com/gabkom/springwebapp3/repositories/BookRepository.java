package com.gabkom.springwebapp3.repositories;

import com.gabkom.springwebapp3.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
