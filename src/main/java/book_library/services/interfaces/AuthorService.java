package book_library.services.interfaces;

import book_library.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAllAuthors();

    Author getRandomAuthor();



}
