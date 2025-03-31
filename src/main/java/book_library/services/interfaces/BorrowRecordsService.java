package book_library.services.interfaces;

import book_library.DTO.BorrowRecordDTO;
import book_library.entities.Book;
import book_library.entities.BorrowRecord;
import book_library.entities.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BorrowRecordsService {

    void borrowBook(BorrowRecordDTO borrowRecordData);

    void returnBook(User user, Book book, LocalDate borrowDate);

    List<BorrowRecord> findBorrowedBooksByUser(User user);

    List<BorrowRecord> findOverdueBooks();

    boolean isBookBorrowed(Optional<Book> book);
}
