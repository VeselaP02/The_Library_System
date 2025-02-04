package book_library.services;

import book_library.entities.Book;
import book_library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private  BookRepository bookRepository;
    @Override
    public void findBook(Book book) {

        Book foundBook = this.bookRepository.findByTitle(book.getTitle());

        if (foundBook == null){
            bookRepository.save(book);
        } else {
            throw new RuntimeException("Book is not found");
        }
    }
}
