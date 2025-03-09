package book_library.repositories;

import book_library.entities.Author;
import book_library.entities.Book;
import book_library.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    List<Book> findByAuthor_FirstNameAndAuthor_LastName(String firstName, String lastName);

    List<Book> findByLibraryBranch_Name(String branchName);

    List<Book> findByBookStatus(BookStatus bookStatus);
}