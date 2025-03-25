package book_library.exceptions;

public class PasswordDigitException extends RuntimeException {
    public PasswordDigitException(String reason) {
        super(reason);
    }
}
