package my.project.authorizationservice.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientPerson(@NotBlank @Size(min = 2, max = 32) String login, String password) {
}
