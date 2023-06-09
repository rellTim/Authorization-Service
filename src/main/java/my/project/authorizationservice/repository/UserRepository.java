package my.project.authorizationservice.repository;

import my.project.authorizationservice.client.ClientPerson;
import my.project.authorizationservice.enumpackeg.Authorities;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(ClientPerson person);
    ClientPerson register(ClientPerson person);
}
