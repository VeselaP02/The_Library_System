package book_library.services;

import book_library.entities.Book;
import book_library.entities.BorrowRecord;
import book_library.entities.User;
import book_library.repositories.BookRepository;
import book_library.repositories.BorrowRecordRepository;
import book_library.repositories.UserRepository;
import book_library.services.interfaces.BorrowRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        if (book.getAvailable()){
            BorrowRecord borrowRecords = new BorrowRecord();

            borrowRecords.setUser(user);

            borrowRecords.setBook(book);

            borrowRecords.setBorrowDate(LocalDate.now());

            book.setAvailable(false);

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

            book.setAvailable(false);

            borrowRecordRepository.save(foundBorrow);

            bookRepository.save(book);
        } else {
            throw new RuntimeException("No active borrow record found");
        }

    }
}
