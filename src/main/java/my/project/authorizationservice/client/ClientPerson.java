package my.project.authorizationservice.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPerson {
    @NotBlank
    @Size(min = 2, max = 32)
    private String login;
    private String password;
}
