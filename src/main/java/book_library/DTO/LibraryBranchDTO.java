package book_library.DTO;

public class LibraryBranchDTO {

    private String name;

    private String location;

    public LibraryBranchDTO(String [] libraryBranchData) {
        this.name = libraryBranchData[1];
        this.location = libraryBranchData[2];
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
