package com.gabkom.springwebapp3.repositories;

import com.gabkom.springwebapp3.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
