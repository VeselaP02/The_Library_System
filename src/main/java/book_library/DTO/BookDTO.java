package book_library.DTO;

import book_library.enums.Genre;

public class BookDTO {

    private String title;

    public BookDTO(String [] bookData) {
        this.title = bookData[1];
    }

    public String getTitle() {
        return title;
    }

}
