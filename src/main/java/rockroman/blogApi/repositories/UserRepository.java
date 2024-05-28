package rockroman.blogApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import rockroman.blogApi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}
