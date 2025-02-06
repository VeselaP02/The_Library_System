package book_library;

import book_library.entities.Book;
import book_library.entities.Genre;
import book_library.entities.User;
import book_library.services.BookService;
import book_library.services.BorrowRecordsService;
import book_library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowRecordsService borrowRecordsService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("vesi1456","kaKA896");
        userService.registerUser(user);

        Book book = new Book("After","Anna Todd", Genre.Romance,LocalDate.parse("2006-10-15", DateTimeFormatter.ISO_LOCAL_DATE));
        bookService.findBook(book);

        borrowRecordsService.borrowBook(user,book);

    }
}
