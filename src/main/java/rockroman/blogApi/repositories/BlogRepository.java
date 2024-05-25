package rockroman.blogApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rockroman.blogApi.entities.Blog;

/**
 * Jpa repository is better than simple
 * crudRepository since we have access to pagination and sorting
 */
public interface BlogRepository extends JpaRepository<Blog,Long> {
}
