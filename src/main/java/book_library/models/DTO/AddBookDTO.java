package book_library.models.DTO;

public class AddBookDTO {
    private String title;

    public AddBookDTO(String [] bookData) {
        this.title = bookData[0];
    }

    public String getTitle() {
        return title;
    }

}
