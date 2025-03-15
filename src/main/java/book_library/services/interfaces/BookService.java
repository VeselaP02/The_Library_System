package book_library.services.interfaces;

import book_library.entities.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    List<Book> findBooksByAuthor(String firstName, String lastName);

    List<Book> findAvailableBooks();

    List<Book> findBooksByLibraryBranch(String branchName);  // Метод за книги по библиотека

    Book findByTitle(String title);  // Намиране на книга по заглавие

    void deleteBook(Long id);  // Изтриване на книга

    List<Book> getAllBooks();

    boolean existsByTitle(String title);
}
