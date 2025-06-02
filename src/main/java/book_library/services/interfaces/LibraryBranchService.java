package book_library.services.interfaces;

import book_library.models.entities.LibraryBranch;

import java.util.List;

public interface LibraryBranchService {
    LibraryBranch createLibraryBranch(LibraryBranch libraryBranch);

    List<LibraryBranch> getAllBranches();

    LibraryBranch getBranchByName(String name);

    List<LibraryBranch> getBranchesByLocation(String location);

    void deleteLibraryBranch(Long id);
}
