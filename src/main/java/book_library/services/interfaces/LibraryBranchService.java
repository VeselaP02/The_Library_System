package book_library.services.interfaces;

import book_library.entities.LibraryBranch;

import java.util.List;
import java.util.Set;

public interface LibraryBranchService {
    LibraryBranch createLibraryBranch(LibraryBranch libraryBranch);

    List<LibraryBranch> getAllBranches();

    LibraryBranch getBranchByName(String name);

    List<LibraryBranch> getBranchesByLocation(String location);

    void deleteLibraryBranch(Long id);
}
