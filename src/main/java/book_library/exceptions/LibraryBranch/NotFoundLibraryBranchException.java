package book_library.exceptions.LibraryBranch;

public class NotFoundLibraryBranchException extends RuntimeException{

    public NotFoundLibraryBranchException(String reason) {
        super(reason);
    }
}
