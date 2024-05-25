package rockroman.blogApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rockroman.blogApi.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
