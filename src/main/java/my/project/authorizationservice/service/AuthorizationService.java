package my.project.authorizationservice.service;

import lombok.RequiredArgsConstructor;
import my.project.authorizationservice.client.ClientPerson;
import my.project.authorizationservice.enumpackeg.Authorities;
import my.project.authorizationservice.error.InvalidCredentials;
import my.project.authorizationservice.error.UnauthorizedUser;
import my.project.authorizationservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final UserRepository repository;

    public List<Authorities> getAuthorities(ClientPerson person) {
        if (isEmpty(person.login()) || isEmpty(person.password())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = repository.getUserAuthorities(person);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + person.login());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public ClientPerson register(ClientPerson person) {
        if (person != null) {
            return repository.register(person);
        }
        throw new InvalidCredentials();
    }
}
