package book_library.exceptions;

public class ConfirmationPasswordException extends RuntimeException {
    public ConfirmationPasswordException(String reason) {
        super(reason);
    }
}
