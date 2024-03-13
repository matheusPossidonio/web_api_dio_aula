package dio.web_api.exceptions;

public class NullFieldException extends RuntimeException{

    public NullFieldException(){super("Campos vazios detectados!");}
    
    public NullFieldException(String message){super(message);}
}
