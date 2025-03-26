package book_library.services;

import book_library.entities.Author;
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

        return this.authorRepository.findByFirstNameAndLastNameIgnoreCase(firstName,lastName);
    }

    @Override
    public Author deleteAuthor(Author author) {
        return authorRepository.deleteByAuthor(author);
    }
}
