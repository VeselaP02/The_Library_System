package book_library.exceptions.registration;

public class PasswordLengthException extends RuntimeException {
    public PasswordLengthException(String reason) {
        super(reason);
    }
}
