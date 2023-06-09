package my.project.authorizationservice.repository;

import my.project.authorizationservice.client.ClientPerson;
import my.project.authorizationservice.enumpackeg.Authorities;
import my.project.authorizationservice.error.ConflictUsers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Value("${client.admin}")
    private String admin;
    @Value("${client.passwordAdmin}")
    private String passwordAdmin;
    private final Map<String, String> gagDataBases = new ConcurrentHashMap<>();

    @Override
    public List<Authorities> getUserAuthorities(ClientPerson person) {
        String login = person.getLogin();
        String password = person.getPassword();
        List<Authorities> authorities = new ArrayList<>();
        if (login.equals(admin) && password.equals(passwordAdmin)) {
            gagDataBases.put(admin, passwordAdmin);
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
            return authorities;
        }
        if (gagDataBases.containsKey(person.getLogin()) && person.getPassword() != null) {
            authorities.add(Authorities.READ);
        }
        return authorities;
    }

    @Override
    public ClientPerson register(ClientPerson person) {
        String login = person.getLogin();
        String password = person.getPassword();
        if (!gagDataBases.containsKey(login)) {
            gagDataBases.put(login, password);
            return person;
        }
        throw new ConflictUsers("The name is taken, sorry BRO");
    }
}
