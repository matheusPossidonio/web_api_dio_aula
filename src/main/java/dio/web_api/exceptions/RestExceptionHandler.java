package dio.web_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMessage> UserNotFoundHandler(UserNotFoundException e){
        RestErrorMessage respostaTratada = new  RestErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaTratada);
    }
    
    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity<RestErrorMessage> handleNullFieldException(NullFieldException e) {
        RestErrorMessage respostaTratada = new  RestErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaTratada);
    }
}
