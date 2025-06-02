package book_library.repositories;

import book_library.models.entities.Book;
import book_library.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    List<Book> findByAuthor_FirstNameAndAuthor_LastName(String firstName, String lastName);

    List<Book> findByLibraryBranch_Name(String branchName);

    List<Book> findByBookStatus(BookStatus bookStatus);


}