package book_library.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String reason) {
        super(reason);
    }
}
