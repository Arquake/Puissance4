package Modele.Exception;

public class invalidColumnException extends Exception{


    public invalidColumnException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Invalid column";
    }
}
