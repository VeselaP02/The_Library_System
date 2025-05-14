package book_library.DTO;

import book_library.exceptions.registration.IncorrectEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static book_library.enums.ExceptionMessages.EMAIL_EXCEPTION;

public class AddLibrarianDTO {

    private String firstName;

    private String lastName;

    private String email;

    public AddLibrarianDTO(String [] librarianData) {
        this.firstName = librarianData[0];
        this.lastName = librarianData[1];
        this.setEmail(librarianData[2]);
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
        Matcher emailMatcher = emailPattern.matcher(email);

        if (!emailMatcher.matches()){
            throw new IncorrectEmailException(EMAIL_EXCEPTION);
        }
        this.email = email;
    }
}
