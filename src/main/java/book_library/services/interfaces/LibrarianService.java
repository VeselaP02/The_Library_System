package book_library.services.interfaces;

import book_library.entities.Librarian;
import book_library.entities.LibraryBranch;

import java.util.Set;

public interface LibrarianService {
    LibrarianService addLibrarian(String firstName, String lastName, String email, LibraryBranch branch,Long branchId);

    Set<Librarian> getLibrariansByBranch(Long branchId);

    Librarian updateLibrarian(Long librarianId, String newFirstName, String newLastName, Long newBranchId);

    void deleteLibrarian(Long librarianId);
}
