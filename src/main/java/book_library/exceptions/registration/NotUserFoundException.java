package book_library.exceptions.registration;

public class NotUserFoundException extends RuntimeException {
    public NotUserFoundException(String reason) {
        super(reason);
    }
}
