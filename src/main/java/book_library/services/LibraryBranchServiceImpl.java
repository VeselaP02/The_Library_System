package book_library.services;

import book_library.entities.LibraryBranch;
import book_library.repositories.LibraryBranchRepository;
import book_library.services.interfaces.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
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

    @Override
    public List<LibraryBranch> getBranchesByLocation(String location) {
        return libraryBranchRepository.findByLocation(location);
    }

    @Override
    public void deleteLibraryBranch(Long id) {
        if (!libraryBranchRepository.existsById(id)) {
            throw new RuntimeException("Library Branch not found!");
        }

        this.libraryBranchRepository.deleteById(id);
    }
}
