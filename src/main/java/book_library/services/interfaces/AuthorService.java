package book_library.services.interfaces;

import book_library.DTO.AuthorDTO;
import book_library.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorByFullName(String firstName,String lastName);

    Author deleteAuthor(Author author);



}
