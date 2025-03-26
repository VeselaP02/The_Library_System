package book_library.exceptions.registration;

public class PasswordDigitException extends RuntimeException {
    public PasswordDigitException(String reason) {
        super(reason);
    }
}
