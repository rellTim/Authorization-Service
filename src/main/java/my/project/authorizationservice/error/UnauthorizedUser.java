package my.project.authorizationservice.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
