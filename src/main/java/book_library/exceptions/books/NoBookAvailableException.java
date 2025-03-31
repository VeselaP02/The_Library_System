package book_library.exceptions.books;

public class NoBookAvailableException extends RuntimeException {
    public NoBookAvailableException(String reason) {
        super(reason);
    }
}
