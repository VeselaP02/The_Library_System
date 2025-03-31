package book_library.DTO;

import book_library.enums.ExceptionMessages;
import book_library.exceptions.IncorrectEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static book_library.enums.ExceptionMessages.EMAIL_EXCEPTION;

public class LibrarianDTO {

    private String firstName;

    private String lastName;

    private String email;

    public LibrarianDTO(String [] librarianData) {
        this.firstName = librarianData[1];
        this.lastName = librarianData[2];
        this.setEmail(librarianData[3]);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String email_regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(email_regex);
        Matcher emailMatcher = emailPattern.matcher(this.email);

        if (!emailMatcher.matches()){
            throw new IncorrectEmailException(EMAIL_EXCEPTION);
        }
        this.email = email;
    }
}
