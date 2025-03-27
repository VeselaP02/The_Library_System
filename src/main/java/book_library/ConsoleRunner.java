package book_library;

import book_library.DTO.authors.AuthorDTO;
import book_library.entities.Author;
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

    Scanner scanner = new Scanner(System.in);

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

        String commandName = scanner.nextLine();

        while (!commandName.equals("END")) {
            String result = switch (commandName) {
                case "ADD_AUTHOR" -> addAuthor(addAuthorData());
                case "GET_AUTHOR" -> getAuthorByFullName(getAuthorData());
                case "DELETE_AUTHOR" -> deleteAuthor(getAuthorData());
                default -> "No such command";
            };

            System.out.println(result);

            commandName = scanner.nextLine();
        }
    }

    private String deleteAuthor(String[] authorData) {
        AuthorDTO findAuthor = new AuthorDTO(authorData);

        Author author = mapper.map(findAuthor,Author.class);
        authorService.deleteAuthor(author);

        return String.format(DELETE_AUTHOR_SUCCESSFULLY,author.getFirstName(),author.getLastName());
    }


    private String getAuthorByFullName(String[] authorData) {
        AuthorDTO findAuthor = new AuthorDTO(authorData);

        Author author = mapper.map(findAuthor,Author.class);
        authorService.getAuthorByFullName(author.getFirstName(),author.getLastName());
        return String.format(FOUND_AUTHOR_SUCCESSFULLY,author.getFirstName(),author.getLastName());
    }


    private String addAuthor(String[] data) {
        AuthorDTO authorData = new AuthorDTO(data);

        Author addedAuthor = mapper.map(authorData,Author.class);
        authorService.addAuthor(addedAuthor);

        return String.format(ADDED_AUTHOR_SUCCESSFULLY,addedAuthor.getFirstName(),addedAuthor.getLastName());
    }

    private String [] addAuthorData(){

        System.out.println(ADD_NEW_AUTHOR);
        System.out.print(FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(LAST_NAME);
        String lastName = scanner.nextLine();


        return new String[]{firstName,lastName};
    }

    private String[] getAuthorData() {

        System.out.print(FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.print(LAST_NAME);
        String lastName = scanner.nextLine();


        return new String[]{firstName,lastName};
    }
}
