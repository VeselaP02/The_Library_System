package book_library.repositories;

import book_library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface BookRepository extends JpaRepository<Book, Long> {


    Book findByTitle(String title);
}