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
        User user = userService.registerUser(new User("mariq_471","sasumAQS",LocalDate.now(),"Karlova 89","088742933314",LocalDate.now()));

//        seedService.seedAuthors();
//
//        Author author = authorService.getRandomAuthor();
//        Book book =bookService.addBook(new Book("The Blue Berry", Genre.Science,LocalDate.parse("2018-07-06", DateTimeFormatter.ISO_LOCAL_DATE),author));


    }
}
