package book_library;

import book_library.DTO.AddAuthorDTO;
import book_library.entities.Author;
import book_library.entities.Book;
import book_library.entities.Librarian;
import book_library.entities.LibraryBranch;
import book_library.exceptions.Librarian.NoFoundLibrarianException;
import book_library.exceptions.LibraryBranch.NotFoundLibraryBranchException;
import book_library.exceptions.authors.NotFoundAuthorException;
import book_library.exceptions.registration.ConfirmationPasswordException;
import book_library.repositories.LibraryBranchRepository;
import book_library.services.interfaces.*;
import book_library.services.seed.SeedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookLibraryRunnerNegativeTests {
    @Mock
    private LibraryBranchRepository libraryBranchRepository;

    @Mock
    private AuthorService authorService;
    @Mock
    private BookService bookService;
    @Mock
    private BorrowRecordsService borrowRecordsService;
    @Mock
    private UserService userService;
    @Mock
    private LibraryBranchService libraryBranchService;
    @Mock
    private LibrarianService librarianService;
    @Mock
    private SeedService seedService;
    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private BookLibraryRunner runner;



    @Test
    public void testAddAuthor_withNullData_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> runner.addAuthor(null));
    }

    @Test
    public void testRegisterUser_invalidPasswords_shouldThrowException() {
        String[] data = {"user1", "pass123lkjoAS", "differentPassword"};

        assertThrows(ConfirmationPasswordException.class, () -> runner.registerUser(data));
    }

    @Test
    public void testAddBook_serviceThrowsException_shouldPropagate() {
        String[] data = {"Test Book"};
        doThrow(new RuntimeException("DB error")).when(bookService).addBook(any(Book.class));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> runner.addBook(data));
        Assertions.assertEquals("DB error", ex.getMessage());
    }

    @Test
    void deleteAuthor_ShouldThrowException_WhenAuthorDoesNotExist() {
        String[] authorData = {"Jake", "Smith"};
        AddAuthorDTO findAuthor = new AddAuthorDTO(authorData);
        Author author = new Author();
        author.setFirstName("Jake");
        author.setLastName("Smith");

        when(mapper.map(any(AddAuthorDTO.class),eq(Author.class))).thenReturn(author);
        doThrow(new NotFoundAuthorException("The author   was not found")).when(authorService).deleteAuthor(author);

        NotFoundAuthorException exception = assertThrows(NotFoundAuthorException.class, () -> {
            runner.deleteAuthor(authorData);
        });

        Assertions.assertEquals("The author  was not found", exception.getMessage());
    }

    @Test
    public void testAddBorrowRecord_nullInput_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> runner.addBorrowRecord(null));
    }

    @Test
    public void testAddLibraryBranch_serviceFails_shouldThrowException() {
        String[] data = {"BranchName","Kartal 17"};
        doThrow(new RuntimeException("Cannot save branch")).when(libraryBranchService)
                .createLibraryBranch(any(LibraryBranch.class));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> runner.addLibraryBranch(data));
        Assertions.assertEquals("Cannot save branch", ex.getMessage());
    }


    @Test
    public void testAddLibrarian_invalidLibraryBranchId_shouldThrowException() {
        LibraryBranch fakeBranch = new LibraryBranch();
        fakeBranch.setId(123L);

        Librarian librarian = new Librarian();
        librarian.setLibraryBranch(fakeBranch);

        when(libraryBranchRepository.findById(123L)).thenReturn(Optional.empty());

        assertThrows(NotFoundLibraryBranchException.class, () -> librarianService.addLibrarian(librarian));

    }
}
