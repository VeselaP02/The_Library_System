package book_library.services;

import book_library.entities.LibraryBranch;
import book_library.repositories.LibraryBranchRepository;
import book_library.services.interfaces.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class LibraryBranchServiceImpl implements LibraryBranchService {

    private final LibraryBranchRepository libraryBranchRepository;

    @Autowired
    public LibraryBranchServiceImpl(LibraryBranchRepository libraryBranchRepository) {
        this.libraryBranchRepository = libraryBranchRepository;
    }

    @Override
    public LibraryBranch createLibraryBranch(String name, String location) {
        LibraryBranch libraryBranch = new LibraryBranch(name,location);
        return libraryBranchRepository.save(libraryBranch);
    }

    @Override
    public List<LibraryBranch> getAllBranches() {
        return libraryBranchRepository.findAll();
    }

    @Override
    public LibraryBranch getBranchByName(String name) {
        return libraryBranchRepository.findByName(name);
    }
}
