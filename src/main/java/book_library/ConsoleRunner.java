package book_library;

import book_library.entities.Author;
import book_library.entities.Book;
import book_library.entities.Genre;
import book_library.entities.User;
import book_library.services.AuthorService;
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

    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {
        User user = userService.registerUser(new User("vesi1456","kaKA896",LocalDate.now(),LocalDate.now()));


        Author author = authorService.addAuthor(new Author("Anna","Todd"));
        Book book =bookService.addBook(new Book("After", Genre.Romance,LocalDate.parse("2006-10-15", DateTimeFormatter.ISO_LOCAL_DATE),author));

        borrowRecordsService.borrowBook(user,book);

    }
}
