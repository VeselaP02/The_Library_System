package book_library.services.interfaces;

import book_library.entities.LibraryBranch;

import java.util.List;
import java.util.Set;

public interface LibraryBranchService {
    LibraryBranch createLibraryBranch(String name,String location);

    List<LibraryBranch> getAllBranches();

    LibraryBranch getBranchByName(String name);
}
