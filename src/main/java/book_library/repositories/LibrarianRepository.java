package book_library.repositories;

import book_library.entities.Librarian;
import book_library.entities.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Long> {

    Set<Librarian> findByLibraryBranch(LibraryBranch libraryBranch);

   //TODO: To change the query request to include the librarian's full name
    @Query("SELECT l FROM Librarian l WHERE l.lastName LIKE %:name%")
    Set<Librarian> findByNameContaining(@Param("name") String name);
    }