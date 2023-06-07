package my.project.authorizationservice.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials (String msg){
        super(msg);
    }
}
