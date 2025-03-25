package book_library.exceptions.registration;

public class IncorrectUsernameException extends RuntimeException {
    public IncorrectUsernameException(String reason) {
        super(reason);
    }
}
