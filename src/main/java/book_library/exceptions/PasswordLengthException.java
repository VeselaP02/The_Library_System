package book_library.exceptions;

public class PasswordLengthException extends RuntimeException {
    public PasswordLengthException(String reason) {
        super(reason);
    }
}
