package book_library.services.interfaces;

import book_library.models.entities.Librarian;

import java.util.List;

public interface LibrarianService {
    Librarian addLibrarian(Librarian librarian);

    List<Librarian> getLibrariansByBranch(Long branchId);

    void deleteLibrarian(Long librarianId);
}
