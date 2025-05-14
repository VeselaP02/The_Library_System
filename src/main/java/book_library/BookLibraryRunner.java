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

import static book_library.enums.CommandsMessages.*;
import static book_library.enums.ConsoleMessages.*;

@Component
public class BookLibraryRunner implements CommandLineRunner {

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
    public BookLibraryRunner(UserService userService, BookService bookService, BorrowRecordsService borrowRecordsService, AuthorService authorService, LibraryBranchService libraryBranchService, SeedService seedService, LibrarianService librarianService) {
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

        this.seedService.seedAuthors();
        System.out.println("Please insert your command:");

        String commandName = scanner.nextLine();

        while (!commandName.equals("END")) {
            String result = switch (commandName) {
                case ADD_AUTHOR -> addAuthor(addAuthorData());
                case GET_AUTHOR -> getAuthor(getAuthorData());
                case DELETE_AUTHOR -> deleteAuthor(getAuthorData());
                case ADD_BOOK -> addBook(addBookData());
                case DELETE_BOOK -> deleteBook(getBookData());
                case REGISTER_USER -> registerUser(addUserData());
                case DELETE_USER -> deleteUser(getUserDeleteData());
                case ADD_BORROW_RECORD -> addBorrowRecord(addBorrowRecordData());
                case ADD_LIBRARY_BRANCH -> addLibraryBranch(addLibraryBranchData());
                case ADD_LIBRARIAN -> addLibrarian(addLibrarianData());
                default -> "No such command";
            };

            System.out.println(result);

            commandName = scanner.nextLine();
        }
    }

    public String deleteUser(String [] userData){
        DeleteUserDTO deleteUserDTO = new DeleteUserDTO(userData);

        return String.format(DELETE_USER_SUCCESSFULLY,deleteUserDTO.getUsername());

    }

    private String [] getUserDeleteData(){
        System.out.println(USERNAME);
        String username = scanner.nextLine();

        return new String []{username};
    }
    public String deleteBook(String [] bookData){
        AddBookDTO bookDTO = new AddBookDTO(bookData);
        Book book = mapper.map(bookDTO, Book.class);
        bookService.deleteBook(book.getId());

        return String.format(DELETE_BOOK_SUCCESSFULLY,book.getTitle());

    }

    private String [] getBookData(){
        System.out.println(BOOK_TITLE);
        String bookTitle = scanner.nextLine();

        return new String []{bookTitle};
    }


    public String deleteAuthor(String[] authorData) {
        AddAuthorDTO findAuthor = new AddAuthorDTO(authorData);

        Author author = mapper.map(findAuthor,Author.class);
        authorService.deleteAuthor(author);

        return String.format(DELETE_AUTHOR_SUCCESSFULLY,author.getFirstName(),author.getLastName());
    }


    public String getAuthor(String[] authorData) {
        AddAuthorDTO findAuthor = new AddAuthorDTO(authorData);

        Author author = mapper.map(findAuthor,Author.class);
        authorService.getAuthorByFullName(author.getFirstName(),author.getLastName());
        return String.format(FOUND_AUTHOR_SUCCESSFULLY,author.getFirstName(),author.getLastName());
    }


    public String addAuthor(String[] data) {
        AddAuthorDTO authorData = new AddAuthorDTO(data);

        Author addedAuthor = mapper.map(authorData,Author.class);
        authorService.addAuthor(addedAuthor);

        return String.format(ADDED_AUTHOR_SUCCESSFULLY,addedAuthor.getFirstName(),addedAuthor.getLastName());
    }

    private String [] addAuthorData(){

        System.out.println(ADD_NEW_AUTHOR);
        System.out.println(FIRST_NAME);
        String firstName = scanner.nextLine();

        System.out.println(LAST_NAME);
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

    public String addBook(String[] data) {
        AddBookDTO bookData = new AddBookDTO(data);
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

    public String registerUser(String[] data) {
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

    public String addBorrowRecord(String[] data) {
        BorrowRecordDTO borrowRecordDTO = new BorrowRecordDTO(data);
        borrowRecordsService.borrowBook(borrowRecordDTO);
        return ADDED_BORROW_RECORD_SUCCESSFULLY;
    }

    private String[] addBorrowRecordData() {
        System.out.println(ADD_NEW_BORROW_RECORD);

        System.out.println(USER_ID);
        String userId = scanner.nextLine().trim();

        System.out.println(BOOK_ID);
        String bookId = scanner.nextLine().trim();


        return new String[]{userId, bookId};
    }

    public String addLibraryBranch(String[] data) {
        LibraryBranchDTO branchData = new LibraryBranchDTO(data);
        LibraryBranch branch = mapper.map(branchData, LibraryBranch.class);
        libraryBranchService.createLibraryBranch(branch);
        return String.format(ADDED_LIBRARY_BRANCH_SUCCESSFULLY, branch.getName(),branch.getLocation());
    }

    private String[] addLibraryBranchData() {
        System.out.println(ADD_NEW_LIBRARY_BRANCH);
        System.out.print(BRANCH_NAME);
        String name = scanner.nextLine();

        System.out.println(BRANCH_LOCATION);
        String location = scanner.nextLine();
        return new String[]{name,location};
    }

    public String addLibrarian(String[] data) {
        AddLibrarianDTO librarianData = new AddLibrarianDTO(data);
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
        System.out.println(EMAIL);
        String email = scanner.nextLine();
        return new String[]{firstName, lastName,email};
    }
}
