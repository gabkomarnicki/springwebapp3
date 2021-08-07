package com.gabkom.springwebapp3.controllers;

import com.gabkom.springwebapp3.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this tells Spring to make this into an MVC
public class BookController {

    private final BookRepository bookRepository; // asking Spring to inject a BookRepository

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // this method will be invoked when the /books url is entered
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
