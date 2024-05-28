package rockroman.blogApi.Dto;

import rockroman.blogApi.enums.UserRole;

public record SignUpDto(String login, String password, UserRole role) {
}
