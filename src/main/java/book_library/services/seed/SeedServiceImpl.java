package book_library.services.seed;

import book_library.models.DTO.AddAuthorDTO;
import book_library.models.entities.Author;
import book_library.repositories.AuthorRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static book_library.enums.Paths.AUTHORS_JSON_PATH;

@Service
public class SeedServiceImpl implements SeedService{

    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.mapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedAuthors() throws IOException {
        FileReader fileReader = new FileReader(AUTHORS_JSON_PATH.toFile());
        AddAuthorDTO[] author = this.gson.fromJson(fileReader, AddAuthorDTO[].class);

        List<Author> authors = Arrays.stream(author)
                .map(importDTO -> this.mapper.map(importDTO, Author.class))
                .collect(Collectors.toList());

        this.authorRepository.saveAll(authors);

    }
}
