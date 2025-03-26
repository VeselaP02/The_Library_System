package book_library.services;

import book_library.entities.Author;
import book_library.exceptions.authors.NotFoundAuthorException;
import book_library.repositories.AuthorRepository;
import book_library.services.interfaces.AuthorService;
import org.springframework.stereotype.Service;
import java.util.List;

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
            throw new NotFoundAuthorException(String.format("The author %s %s was not found",firstName,lastName));
        }
        return searchAuthor;


    }

    @Override
    public Author deleteAuthor(Author author) {
        return authorRepository.deleteByAuthor(author);
    }
}
