package meinVersuch;

public class DataFileException extends Exception{
    public DataFileException(String message, Throwable cause) {
        //nimmt massage und andere Exception entgegen
        super(message, cause);
    }

    public DataFileException(String message) {
        super(message);
    }
}
