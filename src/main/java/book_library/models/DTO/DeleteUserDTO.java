package book_library.models.DTO;

public class DeleteUserDTO {

    private String username;

    public DeleteUserDTO(String [] userData) {
        this.username = userData[0];
    }

    public String getUsername() {
        return username;
    }
}
