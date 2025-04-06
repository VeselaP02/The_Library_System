package book_library.DTO;

import book_library.exceptions.registration.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import book_library.enums.ExceptionMessages.*;

import static book_library.enums.ExceptionMessages.*;

public class RegisterDTO {

    private String username;

    private String password;

    private String confirmPassword;

    public RegisterDTO(String [] userData) {
        this.username = userData[0];
        this.password = userData[1];
        this.confirmPassword = userData[2];
    }

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
            throw new IncorrectUsernameException(USERNAME_EXCEPTION);
        }
    }

    private void passwordValidation() {
        if (password.length() < 6) {
            throw new PasswordLengthException(PASSWORD_LENGTH_EXCEPTION);
        } else if (password.chars().noneMatch(Character::isUpperCase)) {
            throw new PasswordUpperCaseException(PASSWORD_UPPERCASE_EXCEPTION);
        } else if (password.chars().noneMatch(Character::isLowerCase)) {
            throw new PasswordLowerCaseException(PASSWORD_LOWERCASE_EXCEPTION);
        } else if (password.chars().noneMatch(Character::isDigit)) {
            throw new PasswordDigitException(PASSWORD_DIGIT_EXCEPTION);
        }
    }

    private void confirmPasswordValidation() {
        if (!password.equals(confirmPassword)){
            throw new ConfirmationPasswordException(CONFIRMATION_PASSWORD_EXCEPTION);
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
