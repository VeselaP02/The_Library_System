package book_library.exceptions.registration;

public class PasswordUpperCaseException extends RuntimeException {
    public PasswordUpperCaseException(String reason) {
        super(reason);
    }
}
