package book_library.services;

import book_library.entities.Author;
import book_library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {

           return authorRepository.save(author);

    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();

        long authorId = new Random().nextInt((int)size) +1;

        return this.authorRepository.findById(authorId).get();
    }
}
