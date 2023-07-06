package my.project.authorizationservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Container
    private final GenericContainer<?> appOne = new GenericContainer<>("app:1.0")
            .withExposedPorts(8080);
    @Container
    private final GenericContainer<?> appTwo = new GenericContainer<>("app:2.0")
            .withExposedPorts(8081);
    @Test
    void contextLoads() {
        Integer appPortOne = appOne.getMappedPort(8080);
        Integer appPortTwo = appTwo.getMappedPort(8081);
        ResponseEntity<String> appEntityOne = testRestTemplate.getForEntity("http://localhost:" + appPortOne + "/api/auth/hello", String.class);
        ResponseEntity<String> appEntityTwo = testRestTemplate.getForEntity("http://localhost:" + appPortTwo + "/api/auth/hello", String.class);
        System.out.println(appEntityOne.getBody());
        System.out.println(appEntityTwo.getBody());
        Assertions.assertEquals("Hello - version 1.0" , appEntityOne);
        Assertions.assertEquals("Hello - version 2.0" , appEntityTwo);
    }

}
