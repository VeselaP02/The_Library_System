package book_library;

import book_library.entities.Author;
import book_library.entities.Book;
import book_library.entities.Genre;
import book_library.entities.User;
import book_library.services.*;
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

    @Autowired
    private SeedService seedService;

    @Override
    public void run(String... args) throws Exception {
        User user = userService.registerUser(new User("jhinov16","sasumAQS",LocalDate.now(),LocalDate.now()));

        seedService.seedAuthors();

        Author author = authorService.getRandomAuthor();
        Book book =bookService.addBook(new Book("The Blue Berry", Genre.Science,LocalDate.parse("2018-07-06", DateTimeFormatter.ISO_LOCAL_DATE),author));



    }
}
