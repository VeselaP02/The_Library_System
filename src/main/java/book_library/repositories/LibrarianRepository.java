package book_library.repositories;

import book_library.entities.Librarian;
import book_library.entities.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Long> {

    List<Librarian> findByLibraryBranch(LibraryBranch libraryBranch);

    @Query("SELECT l FROM Librarian l WHERE l.firstName LIKE %:firstName% and l.lastName LIKE %:lastName%")
    List<Librarian> findAllByFirstNameAndLastNameContaining(@Param("firstName") String firstName,@Param("lastName")String lastName);
    }