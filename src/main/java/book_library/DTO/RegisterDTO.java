package book_library.DTO;

import book_library.exceptions.*;
import book_library.exceptions.registration.IncorrectUsernameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterDTO {

    private String username;

    private String password;

    private String confirmPassword;

    public void  validate(){

        usernameValidation();
        passwordValidation();
        confirmPasswordValidation();
    }

    private void usernameValidation() {
        String usernamePattern = "^(?=.{4,20}$)(?!.*[_.]{2})[a-zA-Z][a-zA-Z0-9._]*[a-zA-Z0-9]$";
        Pattern pattern = Pattern.compile(usernamePattern);
        Matcher usernameMatcher = pattern.matcher(this.username);

        if (!usernameMatcher.matches()){
            throw new IncorrectUsernameException("Username is not correct!");
        }
    }

    private void passwordValidation() {
        if (password.length() < 6) {
            throw new PasswordLengthException("Password must be at least 6 symbols!");
        } else if (password.chars().noneMatch(Character::isUpperCase)) {
            throw new PasswordUpperCaseException("Password must must contain at least 1 uppercase letter!");
        } else if (password.chars().noneMatch(Character::isLowerCase)) {
            throw new PasswordLowerCaseException("Password must must contain at least 1 lowercase letter!");
        } else if (password.chars().noneMatch(Character::isDigit)) {
            throw new PasswordDigitException("Password must must contain at least 1 digit!");
        }
    }

    private void confirmPasswordValidation() {
        if (!password.equals(confirmPassword)){
            throw new ConfirmationPasswordException("Password and Confirmation Password wan not match");
        }
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
