package book_library.services.interfaces;

import book_library.models.DTO.BorrowRecordDTO;
import book_library.models.entities.Book;
import book_library.models.entities.BorrowRecord;
import book_library.models.entities.User;

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
