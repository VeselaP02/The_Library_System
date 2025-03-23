package book_library.services;

import book_library.DTO.AuthorDTO;
import book_library.entities.Author;
import book_library.repositories.AuthorRepository;
import book_library.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {

           return authorRepository.save(author);

    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();

        long authorId = new Random().nextInt((int)size) +1;

        return this.authorRepository.findById(authorId).get();
    }

    @Override
    public Author deleteAuthor(Author author) {
        return authorRepository.deleteByAuthor(author);
    }
}
