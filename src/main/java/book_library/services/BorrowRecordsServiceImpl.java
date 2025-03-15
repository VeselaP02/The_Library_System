package book_library.services;

import book_library.entities.Book;
import book_library.entities.BorrowRecord;
import book_library.entities.User;
import book_library.enums.BookStatus;
import book_library.repositories.BookRepository;
import book_library.repositories.BorrowRecordRepository;
import book_library.repositories.UserRepository;
import book_library.services.interfaces.BorrowRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowRecordsServiceImpl implements BorrowRecordsService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    public void borrowBook(User user, Book book) {
        if (book.getBookStatus() == BookStatus.AVAILABLE){
            BorrowRecord borrowRecords = new BorrowRecord();

            borrowRecords.setUser(user);

            borrowRecords.setBook(book);

            borrowRecords.setBorrowDate(LocalDate.now());

            book.setBookStatus(BookStatus.BORROWED);

            borrowRecordRepository.save(borrowRecords);

            bookRepository.save(book);

        } else {
            throw new RuntimeException("Book is not available");
        }

    }

    @Override
    public void returnBook(User user, Book book, LocalDate borrowDate) {

        BorrowRecord foundBorrow = this.borrowRecordRepository.findByUserAndBookAndBorrowDate(user, book, borrowDate);

        if (foundBorrow != null){
            foundBorrow.setReturnDate(LocalDate.now());

            book.setBookStatus(BookStatus.AVAILABLE);

            borrowRecordRepository.save(foundBorrow);

            bookRepository.save(book);
        } else {
            throw new RuntimeException("No active borrow record found");
        }

    }

    @Override
    public List<BorrowRecord> findBorrowedBooksByUser(User user) {
        return borrowRecordRepository.findAllByUser(user);
    }

    @Override
    public List<BorrowRecord> findOverdueBooks() {
        return borrowRecordRepository.findAll()
                .stream()
                .filter(borrowRecord -> borrowRecord.getReturnDate() == null &&
                        borrowRecord.getBorrowDate().isBefore(LocalDate.now().minusWeeks(4)))
                .toList();
    }

    @Override
    public boolean isBookBorrowed(Book book) {
        return borrowRecordRepository.findAll()
                .stream()
                .anyMatch(borrowRecord -> borrowRecord.getBook().equals(book) &&
                        borrowRecord.getBook().getBookStatus() == BookStatus.BORROWED);
    }
}
