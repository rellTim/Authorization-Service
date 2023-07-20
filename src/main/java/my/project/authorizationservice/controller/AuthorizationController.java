package my.project.authorizationservice.controller;

import lombok.RequiredArgsConstructor;
import my.project.authorizationservice.client.ClientPerson;
import my.project.authorizationservice.enumpackeg.Authorities;
import my.project.authorizationservice.service.AuthorizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping("/hello")
    public String hello() {
        return "Hello - " + "version 1.0";
    }

    @GetMapping("/login")
    public List<Authorities> getAuthorities(@ModelAttribute @Validated ClientPerson person) {
        return service.getAuthorities(person);
    }

    @PostMapping("/register")
    public ClientPerson register(@RequestBody @Validated ClientPerson person) {
        System.out.println(person.login() + person.password());
        return service.register(person);
    }
}
