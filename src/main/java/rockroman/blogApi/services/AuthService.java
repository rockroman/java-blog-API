package rockroman.blogApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rockroman.blogApi.Dto.SignUpDto;
import rockroman.blogApi.entities.User;
import rockroman.blogApi.repositories.UserRepository;

import java.util.Collection;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByLogin(username);
        return user;
    }

    public UserDetails signUp(SignUpDto data) {
        if (repository.findByLogin(data.login()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        return repository.save(newUser);
    }
}
