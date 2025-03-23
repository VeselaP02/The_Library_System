package book_library.DTO;

public class AuthorDTO {

    private String firstName;

    private String lastName;

    public AuthorDTO(String [] authorData) {
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
