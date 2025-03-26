package book_library.exceptions.registration;

public class PasswordLowerCaseException extends RuntimeException {
    public PasswordLowerCaseException(String reason) {
        super(reason);
    }
}
