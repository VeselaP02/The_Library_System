package book_library;

import book_library.services.interfaces.*;
import book_library.services.seed.SeedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class BookLibraryRunnerSuccessfulTests {
    private BookLibraryRunner runner;

    private AuthorService authorService;
    private BookService bookService;
    private BorrowRecordsService borrowRecordsService;
    private UserService userService;
    private LibraryBranchService libraryBranchService;
    private LibrarianService librarianService;
    private SeedService seedService;

    @BeforeEach
    public void setup() {
        authorService = mock(AuthorService.class);
        bookService = mock(BookService.class);
        borrowRecordsService = mock(BorrowRecordsService.class);
        userService = mock(UserService.class);
        libraryBranchService = mock(LibraryBranchService.class);
        librarianService = mock(LibrarianService.class);
        seedService = mock(SeedService.class);

        runner = new BookLibraryRunner(
                userService,
                bookService,
                borrowRecordsService,
                authorService,
                libraryBranchService,
                seedService,
                librarianService
        );
    }

    @Test
    public void testAddAuthor() {
        String[] data = {"Ivan", "Petrov"};
        String result = runner.addAuthor(data);
        Assertions.assertEquals("The author Ivan Petrov was added successfully!", result);
    }

    @Test
    public void testGetAuthor() {
        String[] data = {"Ivan", "Petrov"};
        String result = runner.getAuthor(data);
        Assertions.assertEquals("The author Ivan Petrov was found!", result);
    }

    @Test
    public void testDeleteAuthor() {
        String[] data = {"Ivan", "Petrov"};
        String result = runner.deleteAuthor(data);
        Assertions.assertEquals("The author Ivan Petrov was deleted!", result);

    }

    @Test
    public void testAddBook() {
        String[] data = {"Clean Code"};
        String result = runner.addBook(data);
        Assertions.assertEquals("The book Clean Code was added successfully!", result);
    }

    @Test
    public void testDeleteBook() {
        String[] data = {"Clean Code"};
        String result = runner.deleteBook(data);
        Assertions.assertEquals("The book Clean Code was deleted!", result);
    }

    @Test
    public void testRegisterUser() {
        String[] data = {"user1", "passIASD13", "passIASD13"};
        String result = runner.registerUser(data);
        Assertions.assertEquals("The user user1 was register!", result);
    }

    @Test
    public void testDeleteUser() {
        String[] data = {"user1"};
        String result = runner.deleteUser(data);
        Assertions.assertEquals("The user user1 was deleted!", result);
    }

    @Test
    public void testAddBorrowRecord() {
        String[] data = {"1", "2"};
        String result = runner.addBorrowRecord(data);
        Assertions.assertEquals("The borrowRecord was added successfully!", result);
    }

    @Test
    public void testAddLibraryBranch() {
        String[] data = {"Central","ul.Marica 17"};
        String result = runner.addLibraryBranch(data);
        Assertions.assertEquals("The branch Central was added successfully!", result);
    }

    @Test
    public void testAddLibrarian() {
        String[] data = {"Anna", "Ivanova","ninja_17@gamil.com"};
        String result = runner.addLibrarian(data);
        Assertions.assertEquals("The librarian Anna Ivanova was added successfully!", result);
    }
}
