package book_library.exceptions.registration;

public class ConfirmationPasswordException extends RuntimeException {
    public ConfirmationPasswordException(String reason) {
        super(reason);
    }
}
