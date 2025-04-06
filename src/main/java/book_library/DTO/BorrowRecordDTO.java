package book_library.DTO;

public class BorrowRecordDTO {

    private Long userId;

    private Long bookId;

    public BorrowRecordDTO(String [] borrowData) {
        this.userId = Long.parseLong(borrowData[0]);
        this.bookId = Long.parseLong(borrowData[1]);
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
