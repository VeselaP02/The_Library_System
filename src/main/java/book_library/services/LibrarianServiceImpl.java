package book_library.services;

import book_library.entities.Librarian;
import book_library.entities.LibraryBranch;
import book_library.repositories.LibrarianRepository;
import book_library.repositories.LibraryBranchRepository;
import book_library.services.interfaces.LibrarianService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;
    private final LibraryBranchRepository libraryBranchRepository;

    @Autowired
    public LibrarianServiceImpl(LibrarianRepository librarianRepository, LibraryBranchRepository libraryBranchRepository) {
        this.librarianRepository = librarianRepository;
        this.libraryBranchRepository = libraryBranchRepository;
    }


    @Override
    public LibrarianService addLibrarian(String firstName, String lastName, String email, LibraryBranch branch, Long branchId) {
        LibraryBranch libraryBranch = libraryBranchRepository.findById(branchId).orElseThrow(() -> new RuntimeException("Library branch not found"));

        Librarian librarian = new Librarian(firstName,lastName,email,libraryBranch);
        this.librarianRepository.save(librarian);
        return null;
    }

    @Override
    public Set<Librarian> getLibrariansByBranch(Long branchId) {
        LibraryBranch branch = libraryBranchRepository.findById(branchId)
                .orElseThrow(() -> new EntityNotFoundException("Library branch not found"));

        return librarianRepository.findByLibraryBranch(branch);
    }

    @Override
    public Librarian updateLibrarian(Long librarianId, String newFirstName, String newLastName, Long newBranchId) {
        Librarian librarian = librarianRepository.findById(librarianId)
                .orElseThrow(() -> new EntityNotFoundException("Librarian not found"));

        LibraryBranch newBranch = libraryBranchRepository.findById(newBranchId)
                .orElseThrow(() -> new EntityNotFoundException("Library branch not found"));

        librarian.setFirstName(newFirstName);
        librarian.setLastName(newLastName);
        librarian.setLibraryBranch(newBranch);
        return librarianRepository.save(librarian);
    }

    @Override
    public void deleteLibrarian(Long librarianId) {
        if (!librarianRepository.existsById(librarianId)) {
            throw new EntityNotFoundException("Librarian not found");
        }
        librarianRepository.deleteById(librarianId);
    }

}
