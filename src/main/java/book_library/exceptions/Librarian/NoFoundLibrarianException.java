package book_library.exceptions.Librarian;

public class NoFoundLibrarianException extends RuntimeException{
    public NoFoundLibrarianException(String reason) {
        super(reason);
    }
}
