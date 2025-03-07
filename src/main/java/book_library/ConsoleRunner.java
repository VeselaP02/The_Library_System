package book_library;

import book_library.entities.User;
import book_library.services.interfaces.AuthorService;
import book_library.services.interfaces.BookService;
import book_library.services.interfaces.BorrowRecordsService;
import book_library.services.interfaces.UserService;
import book_library.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

    }
}
