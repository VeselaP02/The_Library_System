package book_library.exceptions.registration;

public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException(String reason) {
        super(reason);
    }
}
