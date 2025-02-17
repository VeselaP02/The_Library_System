package book_library.repositories;

import book_library.entities.Author;
import book_library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    @Query("SELECT b FROM Book b " +
            " WHERE b.author.firstName = :firstName AND b.author.lastName = :lastName")
    List<Book> findByAuthor_FirstNameAndAuthor_LastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}