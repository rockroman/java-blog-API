package rockroman.blogApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rockroman.blogApi.entities.Author;
import rockroman.blogApi.repositories.AuthorRepository;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // get all authors
    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    // create author
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }
}
