package book_library.DTO;

public class DeleteUserDTO {

    private String username;

    public DeleteUserDTO(String [] userData) {
        this.username = userData[0];
    }

    public String getUsername() {
        return username;
    }
}
