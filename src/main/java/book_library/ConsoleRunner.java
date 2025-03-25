package book_library;

import book_library.DTO.AuthorDTO;
import book_library.entities.Author;
import book_library.enums.ConsoleMessages;
import book_library.services.interfaces.AuthorService;
import book_library.services.interfaces.BookService;
import book_library.services.interfaces.BorrowRecordsService;
import book_library.services.interfaces.UserService;
import book_library.services.seed.SeedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static book_library.enums.ConsoleMessages.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;

    private final BookService bookService;

    private final BorrowRecordsService borrowRecordsService;

    private final AuthorService authorService;

    private final ModelMapper mapper;




    private final SeedService seedService;

    @Autowired
    public ConsoleRunner(UserService userService, BookService bookService, BorrowRecordsService borrowRecordsService, AuthorService authorService, SeedService seedService) {
        this.userService = userService;
        this.bookService = bookService;
        this.borrowRecordsService = borrowRecordsService;
        this.authorService = authorService;
        this.mapper = new ModelMapper();
        this.seedService = seedService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please insert your command:");
        Scanner scanner = new Scanner(System.in);

        String commandName = scanner.nextLine();
        String [] data = scanner.nextLine().split(System.lineSeparator());

        while (!commandName.equals("END")) {
            String result = switch (commandName) {
                case "ADD_AUTHOR" -> addAuthor(authorInformation());
                default -> "No such command";
            };

            System.out.println(result);

            commandName = scanner.nextLine();
        }
    }

    private String addAuthor(String[] data) {
        AuthorDTO authorData = new AuthorDTO(data);

        Author addedAuthor = mapper.map(authorData,Author.class);
        authorService.addAuthor(addedAuthor);

        return String.format(ADDED_AUTHOR_SUCCESSFULLY,addedAuthor.getFirstName(),addedAuthor.getLastName());
    }

    private String [] authorInformation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(ADD_NEW_AUTHOR);
        System.out.print(AUTHOR_FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(AUTHOR_LAST_NAME);
        String lastName = scanner.nextLine();


        return new String[]{firstName,lastName};
    }
}
