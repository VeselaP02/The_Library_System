package book_library.services;

import book_library.models.entities.Librarian;
import book_library.models.entities.LibraryBranch;
import book_library.exceptions.LibraryBranch.NotFoundLibraryBranchException;
import book_library.repositories.LibrarianRepository;
import book_library.repositories.LibraryBranchRepository;
import book_library.services.interfaces.LibrarianService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static book_library.enums.ExceptionMessages.LIBRARY_BRANCH_EXCEPTION;


@Service
public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;
    private final LibraryBranchRepository libraryBranchRepository;

    @Autowired
    public LibrarianServiceImpl(LibrarianRepository librarianRepository, LibraryBranchRepository libraryBranchRepository) {
        this.librarianRepository = librarianRepository;
        this.libraryBranchRepository = libraryBranchRepository;
    }


    @Override
    public Librarian addLibrarian(Librarian librarian) {
        LibraryBranch libraryBranch = libraryBranchRepository.findById(librarian.getLibraryBranch().getId()).orElseThrow(() -> new NotFoundLibraryBranchException(LIBRARY_BRANCH_EXCEPTION));
        librarian.setLibraryBranch(libraryBranch);

        return this.librarianRepository.save(librarian);
    }

    @Override
    public List<Librarian> getLibrariansByBranch(Long branchId) {
        LibraryBranch branch = libraryBranchRepository.findById(branchId)
                .orElseThrow(() -> new NotFoundLibraryBranchException(LIBRARY_BRANCH_EXCEPTION));

        return librarianRepository.findByLibraryBranch(branch);
    }

    @Override
    public void deleteLibrarian(Long librarianId) {
        if (!librarianRepository.existsById(librarianId)) {
            throw new EntityNotFoundException("Librarian not found");
        }
        librarianRepository.deleteById(librarianId);
    }

}
