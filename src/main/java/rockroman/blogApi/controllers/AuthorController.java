package rockroman.blogApi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rockroman.blogApi.entities.Author;
import rockroman.blogApi.exceptions.ResourceNotFoundException;
import rockroman.blogApi.repositories.AuthorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    /**
     * private method to implement
     * don't repeat yourself
     * @param x long id of an author
     * @return returning author found
     */
    private Author myFinder(Long x){
        return authorRepository.findById(x)
                .orElseThrow(()-> new ResourceNotFoundException("Author with id:" +x +"does not exist"));


    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> res() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "welcome to my API");
        return response;
    }

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

    @GetMapping("authors/{id}")
    public ResponseEntity <Author> getAuthorById(@PathVariable Long id){
        Author author = myFinder(id);
        return ResponseEntity.ok(author);
    }

    @PatchMapping("authors/{id}")
    public ResponseEntity <Author> updateAuthor(@PathVariable Long id,@RequestBody Author authorDetails){
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Author with id:" +id +"does not exist"));
        if (authorDetails.getName() != null) {
            author.setName(authorDetails.getName());
        }
        if (authorDetails.getEmail() != null) {
            author.setEmail(authorDetails.getEmail());
        }
        Author updatedAuthor = authorRepository.save(author);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("authors/{id}")
    ResponseEntity<Map<String, Boolean>> deleteAuthor(@PathVariable Long id){
        Author author = myFinder(id);
        authorRepository.delete(author);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}
