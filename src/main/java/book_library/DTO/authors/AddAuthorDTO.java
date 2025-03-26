package book_library.DTO.authors;

public class AddAuthorDTO {

    private String firstName;

    private String lastName;

    public AddAuthorDTO(String [] authorData) {
        this.firstName = authorData[0];
        this.lastName = authorData[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
