package book_library.repositories;

import book_library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findByFirstNameIgnoreCase(String firstName);

    List<Author> findByLastNameIgnoreCase(String lastName);

    Author findByFirstNameAndLastNameIgnoreCase(String firstName,String lastName);

    @Query("SELECT DISTINCT a FROM Author a JOIN a.books b WHERE b.releaseDate > :date")
    List<Author> findByReleaseDateAfter(@Param("date") LocalDate date);

    Author deleteByAuthor(Author author);

}
