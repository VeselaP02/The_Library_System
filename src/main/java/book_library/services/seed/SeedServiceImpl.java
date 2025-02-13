package book_library.services.seed;

import book_library.entities.Author;
import book_library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SeedServiceImpl implements SeedService{

    private static final String RESOURCE_PATH = "C:\\Users\\xxxxx\\Downloads\\book_library\\book_library\\src\\main\\resources\\files\\authors.txt";

    private static final String AUTHORS_FILE_PATH = RESOURCE_PATH + "\\authors.txt";

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> s.split(" "))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }
}
