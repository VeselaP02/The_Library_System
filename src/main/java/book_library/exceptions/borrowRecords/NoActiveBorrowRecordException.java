package book_library.exceptions.borrowRecords;

public class NoActiveBorrowRecordException extends RuntimeException {
    public NoActiveBorrowRecordException(String reason) {
        super(reason);
    }
}
