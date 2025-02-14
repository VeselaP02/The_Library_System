package book_library.services;

import book_library.entities.Book;
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
        return bookRepository.findBooksByAuthorName(firstName, lastName);
    }
}
