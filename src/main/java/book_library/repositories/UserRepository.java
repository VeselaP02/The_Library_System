package book_library.repositories;

import book_library.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    List<User> findByRegistrationDateAfter(LocalDate date);

    @Query("SELECT u FROM User u WHERE u.libraryBranch.id = :branchId")
    List<User> findByLibraryBranch(@Param("branchId") Long branchId);

}
