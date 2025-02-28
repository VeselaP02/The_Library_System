package book_library.repositories;

import book_library.entities.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch,Long> {

    LibraryBranch findByName(String name);

    @Query("SELECT lb FROM LibraryBranch lb " +
            " WHERE lb.location = :location")
    Set<LibraryBranch> findByLocation(@Param("location") String location);
}
