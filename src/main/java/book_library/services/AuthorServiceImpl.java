package book_library.services;

import book_library.entities.Author;
import book_library.exceptions.authors.NotFoundAuthorException;
import book_library.repositories.AuthorRepository;
import book_library.services.interfaces.AuthorService;
import org.springframework.stereotype.Service;
import java.util.List;
import book_library.enums.ExceptionMessages.*;

import static book_library.enums.ExceptionMessages.NOT_FOUND_AUTHOR_EXCEPTION;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {

           return authorRepository.save(author);

    }

    @Override
    public List<Author> getAllAuthors() {

        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByFullName(String firstName,String lastName) {

        Author searchAuthor = this.authorRepository.findByFirstNameAndLastNameIgnoreCase(firstName, lastName);
        if (searchAuthor == null){
            throw new NotFoundAuthorException(String.format(NOT_FOUND_AUTHOR_EXCEPTION,firstName,lastName));
        }
        return searchAuthor;


    }

    @Override
    public Author deleteAuthor(Author author) {
        Author searchAuthor = authorRepository.findByFirstNameAndLastNameIgnoreCase(author.getFirstName(), author.getLastName());

        if (searchAuthor == null){
            throw new NotFoundAuthorException(String.format(NOT_FOUND_AUTHOR_EXCEPTION,author.getFirstName(),author.getLastName()));
        }
        return authorRepository.deleteByAuthor(author);
    }
}
