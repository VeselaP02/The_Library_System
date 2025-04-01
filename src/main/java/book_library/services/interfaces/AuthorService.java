package book_library.services.interfaces;

import book_library.entities.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorByFullName(String firstName,String lastName);

    void deleteAuthor(Author author);



}
