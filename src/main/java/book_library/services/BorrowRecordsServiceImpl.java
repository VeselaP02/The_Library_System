package book_library.services;

import book_library.models.DTO.BorrowRecordDTO;
import book_library.models.entities.Book;
import book_library.models.entities.BorrowRecord;
import book_library.models.entities.User;
import book_library.enums.BookStatus;
import book_library.exceptions.books.NoBookAvailableException;
import book_library.exceptions.borrowRecords.NoActiveBorrowRecordException;
import book_library.repositories.BookRepository;
import book_library.repositories.BorrowRecordRepository;
import book_library.repositories.UserRepository;
import book_library.services.interfaces.BorrowRecordsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static book_library.enums.ConsoleMessages.BOOK_EXCEPTION;
import static book_library.enums.ConsoleMessages.BORROW_RECORD_EXCEPTION;

@Service
public class BorrowRecordsServiceImpl implements BorrowRecordsService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    public void borrowBook(BorrowRecordDTO borrowRecordData) {
        ModelMapper mapper = new ModelMapper();
        BorrowRecord borrowRecord = mapper.map(borrowRecordData, BorrowRecord.class);

        User user = borrowRecord.getUser();
        Book book = borrowRecord.getBook();


        if (book.getBookStatus() == BookStatus.AVAILABLE){
            BorrowRecord borrowRecords = new BorrowRecord();

            borrowRecords.setUser(user);

            borrowRecords.setBook(book);

            borrowRecords.setBorrowDate(LocalDate.now());

            book.setBookStatus(BookStatus.BORROWED);

            borrowRecordRepository.save(borrowRecords);

            bookRepository.save(book);

        } else {
            throw new NoBookAvailableException(BOOK_EXCEPTION);
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
            throw new NoActiveBorrowRecordException(BORROW_RECORD_EXCEPTION);
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
    public boolean isBookBorrowed(Optional<Book> book) {
        return borrowRecordRepository.findAll()
                .stream()
                .anyMatch(borrowRecord -> borrowRecord.getBook().equals(book) &&
                        borrowRecord.getBook().getBookStatus() == BookStatus.BORROWED);
    }
}
