package book_library.DTO;

public class AddBookDTO {

    private String title;

    public AddBookDTO(String [] bookData) {
        this.title = bookData[1];
    }

    public String getTitle() {
        return title;
    }

}
