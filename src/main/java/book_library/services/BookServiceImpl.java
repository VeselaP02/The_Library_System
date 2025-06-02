package book_library.services;

import book_library.models.entities.Book;
import book_library.enums.BookStatus;
import book_library.repositories.BookRepository;
import book_library.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private  BookRepository bookRepository;
    @Override
    public Book addBook(Book book) {

        return bookRepository.save(book);

    }

    public List<Book> findBooksByAuthor(String firstName, String lastName) {
        return bookRepository.findByAuthor_FirstNameAndAuthor_LastName(firstName, lastName);
    }

    @Override
    public List<Book> findAvailableBooks() {
        return bookRepository.findByBookStatus(BookStatus.AVAILABLE);
    }

    @Override
    public List<Book> findBooksByLibraryBranch(String branchName) {
        return bookRepository.findByLibraryBranch_Name(branchName);
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean existsByTitle(String title) {
        return bookRepository.findByTitle(title) != null;
    }
}
