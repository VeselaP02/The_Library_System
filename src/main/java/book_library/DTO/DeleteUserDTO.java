package book_library.DTO;

public class DeleteUserDTO {

    private String username;

    public DeleteUserDTO(String [] userData) {
        this.username = userData[1];
    }

    public String getUsername() {
        return username;
    }
}
