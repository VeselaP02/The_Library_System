package book_library.repositories;

import book_library.models.entities.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch,Long> {

    LibraryBranch findByName(String name);

    List<LibraryBranch> findByLocation(String location);

    @Query("SELECT lb FROM LibraryBranch lb JOIN lb.librarians l WHERE l.id = :librarianId")
    LibraryBranch findBranchWithLibrarianId(@Param("librarianId") int librarianId);
}
