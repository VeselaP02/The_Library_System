package book_library.exceptions;

public class PasswordUpperCaseException extends RuntimeException {
    public PasswordUpperCaseException(String reason) {
        super(reason);
    }
}
