package book_library.repositories;

import book_library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    Book findByTitle(String title);
}