package book_library.exceptions.registration;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String reason) {
        super(reason);
    }
}
