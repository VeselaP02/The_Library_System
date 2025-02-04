package book_library.services;

import book_library.entities.Book;
import book_library.entities.User;

import java.time.LocalDate;

public interface BorrowRecordsService {

    void borrowBook(User user, Book book);

    void returnBook(User user, Book book, LocalDate borrowDate);
}
