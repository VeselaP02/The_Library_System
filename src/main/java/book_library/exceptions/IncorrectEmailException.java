package book_library.exceptions;

public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException(String reason) {
        super(reason);
    }
}
