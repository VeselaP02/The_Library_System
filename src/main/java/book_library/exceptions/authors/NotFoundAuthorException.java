package book_library.exceptions.authors;

public class NotFoundAuthorException extends RuntimeException {
    public NotFoundAuthorException(String reason) {
        super(reason);
    }
}
