package my.project.authorizationservice.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedException(UnauthorizedUser msg) {
        log.error("UnauthorizedException: {}", msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsException(InvalidCredentials msg) {
        log.error("InvalidCredentialsException: {}", msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConflictUsers.class)
    public ResponseEntity<String> conflictUsersException(ConflictUsers msg){
        log.error("ConflictUsersException: {}", msg.getMessage());
        return new ResponseEntity<>(msg.getMessage(), HttpStatus.CONFLICT);
    }
}
