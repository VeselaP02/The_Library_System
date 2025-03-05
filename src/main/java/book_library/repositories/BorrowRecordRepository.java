package book_library.repositories;

import book_library.entities.Book;
import book_library.entities.BorrowRecord;
import book_library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Long> {

    BorrowRecord findByUserAndBookAndBorrowDate(User user, Book book, LocalDate borrowDate);
}
