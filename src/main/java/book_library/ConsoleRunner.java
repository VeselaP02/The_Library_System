package book_library;

import book_library.DTO.*;
import book_library.entities.*;
import book_library.services.interfaces.*;
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

    private final LibraryBranchService libraryBranchService;

    private final LibrarianService librarianService;

    private final ModelMapper mapper;


    private final SeedService seedService;


    @Autowired
    public ConsoleRunner(UserService userService, BookService bookService, BorrowRecordsService borrowRecordsService, AuthorService authorService, LibraryBranchService libraryBranchService, SeedService seedService, LibrarianService librarianService) {
        this.userService = userService;
        this.bookService = bookService;
        this.borrowRecordsService = borrowRecordsService;
        this.authorService = authorService;
        this.libraryBranchService = libraryBranchService;
        this.librarianService = librarianService;
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
                case "ADD_BOOK" -> addBook(addBookData());
                case "GET_BOOK" -> getBookByTitle(getBookData());
                case "DELETE_BOOK" -> deleteBook(getBookData());
                case "ADD_USER" -> registerUser(addUserData());
                case "GET_USER" -> getUserByUsername(getUserData());
                case "DELETE_USER" -> deleteUser(getUserData());
                case "ADD_BORROW_RECORD" -> addBorrowRecord(addBorrowRecordData());
                case "ADD_LIBRARY_BRANCH" -> addLibraryBranch(addLibraryBranchData());
                case "ADD_LIBRARIAN" -> addLibrarian(addLibrarianData());
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

    private String addBook(String[] data) {
        BookDTO bookData = new BookDTO(data);
        Book addedBook = mapper.map(bookData, Book.class);
        bookService.addBook(addedBook);
        return String.format(ADDED_BOOK_SUCCESSFULLY, addedBook.getTitle());
    }

    private String[] addBookData() {
        System.out.println(ADD_NEW_BOOK);
        System.out.print(BOOK_TITLE);
        String title = scanner.nextLine();
        return new String[]{title};
    }

    private String registerUser(String[] data) {
        RegisterDTO userData = new RegisterDTO(data);
        userData.validate();
        User addedUser = mapper.map(userData, User.class);
        userService.registerUser(addedUser);
        return String.format(ADDED_USER_SUCCESSFULLY, addedUser.getUsername());
    }

    private String[] addUserData() {
        System.out.println(ADD_NEW_USER);
        System.out.print(USERNAME);
        String username = scanner.nextLine();

        System.out.println(PASSWORD);
        String password = scanner.nextLine();

        System.out.println(CONFIRM_PASSWORD);
        String confirmPassword = scanner.nextLine();
        return new String[]{username,password,confirmPassword};
    }

    private String addBorrowRecord(String[] data) {
        borrowRecordsService.borrowBook(data);
        return ADDED_BORROW_RECORD_SUCCESSFULLY;
    }

    private String[] addBorrowRecordData() {
        System.out.println(ADD_NEW_BORROW_RECORD);

        System.out.println("Въведете ID на потребител: ");
        String username = scanner.nextLine().trim();

        System.out.println("Въведете ID на книга: ");
        String bookTitle = scanner.nextLine().trim();


        return new String[]{username, bookTitle};
    }

    private String addLibraryBranch(String[] data) {
        LibraryBranchDTO branchData = new LibraryBranchDTO(data);
        LibraryBranch branch = mapper.map(branchData, LibraryBranch.class);
        libraryBranchService.createLibraryBranch(branch);
        return String.format(ADDED_LIBRARY_BRANCH_SUCCESSFULLY, branch.getName());
    }

    private String[] addLibraryBranchData() {
        System.out.println(ADD_NEW_LIBRARY_BRANCH);
        System.out.print(BRANCH_NAME);
        String name = scanner.nextLine();

        System.out.println(BRANCH_LOCATION);
        String location = scanner.nextLine();
        return new String[]{name};
    }

    private String addLibrarian(String[] data) {
        LibrarianDTO librarianData = new LibrarianDTO(data);
        Librarian librarian = mapper.map(librarianData, Librarian.class);
        librarianService.addLibrarian(librarian);
        return String.format(ADDED_LIBRARIAN_SUCCESSFULLY, librarian.getFirstName(), librarian.getLastName());
    }

    private String[] addLibrarianData() {
        System.out.println(ADD_NEW_LIBRARIAN);
        System.out.print(FIRST_NAME);
        String firstName = scanner.nextLine();
        System.out.print(LAST_NAME);
        String lastName = scanner.nextLine();
        return new String[]{firstName, lastName};
    }
}
