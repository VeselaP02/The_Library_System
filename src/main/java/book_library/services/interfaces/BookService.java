package book_library.services.interfaces;

import book_library.entities.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    List<Book> findBooksByAuthor(String firstName, String lastName);
}
