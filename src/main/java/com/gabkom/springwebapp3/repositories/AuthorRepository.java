package com.gabkom.springwebapp3.repositories;

import com.gabkom.springwebapp3.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
