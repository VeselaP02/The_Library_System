package book_library.services;

import book_library.models.entities.LibraryBranch;
import book_library.exceptions.LibraryBranch.NotFoundLibraryBranchException;
import book_library.repositories.LibraryBranchRepository;
import book_library.services.interfaces.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static book_library.enums.ExceptionMessages.LIBRARY_BRANCH_EXCEPTION;

@Service
public class LibraryBranchServiceImpl implements LibraryBranchService {

    private final LibraryBranchRepository libraryBranchRepository;

    @Autowired
    public LibraryBranchServiceImpl(LibraryBranchRepository libraryBranchRepository) {
        this.libraryBranchRepository = libraryBranchRepository;
    }

    @Override
    public LibraryBranch createLibraryBranch(LibraryBranch libraryBranch) {
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
            throw new NotFoundLibraryBranchException(LIBRARY_BRANCH_EXCEPTION);
        }

        this.libraryBranchRepository.deleteById(id);
    }
}
