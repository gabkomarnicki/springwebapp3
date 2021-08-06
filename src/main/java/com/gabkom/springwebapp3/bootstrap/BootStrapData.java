package com.gabkom.springwebapp3.bootstrap;

import com.gabkom.springwebapp3.domain.Author;
import com.gabkom.springwebapp3.domain.Book;
import com.gabkom.springwebapp3.domain.Publisher;
import com.gabkom.springwebapp3.repositories.AuthorRepository;
import com.gabkom.springwebapp3.repositories.BookRepository;
import com.gabkom.springwebapp3.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // Spring will perform dependency injection below for the authorRepository and bookRepository
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123123");
//        Publisher publisher = new Publisher("First Publishing Company", "123 Main St", "Springfield", "MA", "123456");

        Publisher publisher = new Publisher();
        publisher.setName("First Publishing Company");
        publisher.setCity("Springfield");
        publisher.setState("MA");

        publisherRepository.save(publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        
//        publisher.getAuthors().add(eric);

        // these will be saved in the H2 database
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","345436362");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());


    }
}
