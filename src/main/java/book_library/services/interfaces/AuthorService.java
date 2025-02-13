package book_library.services.interfaces;

import book_library.entities.Author;

import java.io.IOException;

public interface AuthorService {

    Author addAuthor(Author author);

    Author getRandomAuthor();



}
