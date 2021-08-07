package com.gabkom.springwebapp3.controllers;

import com.gabkom.springwebapp3.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository; // asking Spring to inject a BookRepository

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors") // this method will be invoked when the /authors url is entered
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
