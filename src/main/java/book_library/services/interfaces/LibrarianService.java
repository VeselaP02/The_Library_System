package book_library.services.interfaces;

import book_library.entities.Librarian;
import book_library.entities.LibraryBranch;

import java.util.List;
import java.util.Set;

public interface LibrarianService {
    Librarian addLibrarian(String firstName, String lastName, String email, LibraryBranch branch,Long branchId);

    List<Librarian> getLibrariansByBranch(Long branchId);

    void deleteLibrarian(Long librarianId);
}
