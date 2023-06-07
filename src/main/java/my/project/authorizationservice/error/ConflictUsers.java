package my.project.authorizationservice.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConflictUsers extends RuntimeException{
    public ConflictUsers(String msg){
        super(msg);
    }
}
