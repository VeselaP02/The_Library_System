package book_library.exceptions;

public class PasswordLowerCaseException extends RuntimeException {
    public PasswordLowerCaseException(String reason) {
        super(reason);
    }
}
