package book_library.services;

import book_library.entities.Author;

public interface AuthorService {

    Author addAuthor(Author author);

    Author getRandomAuthor();
}
