package book_library.enums;

public enum ExceptionMessages {

    ;
    public static final String NOT_FOUND_AUTHOR_EXCEPTION = "The author %s %s was not found!";

    public static final String CONFIRMATION_PASSWORD_EXCEPTION = "Password and Confirmation Password wan not match!";

    public static final String USERNAME_EXCEPTION = "Username is not correct!";
    public static final String LIBRARY_BRANCH_EXCEPTION = "Library branch does not exist";

    public static final String PASSWORD_DIGIT_EXCEPTION = "Password must must contain at least 1 digit!";

    public static final String PASSWORD_LENGTH_EXCEPTION = "Password must be at least 6 symbols!";

    public static final String PASSWORD_LOWERCASE_EXCEPTION = "Password must must contain at least 1 lowercase letter!";

    public static final String PASSWORD_UPPERCASE_EXCEPTION = "Password must must contain at least 1 uppercase letter!";

    public static final String USER_EXISTS_EXCEPTION = "User already exists!";

    public static final String NOT_USER_FOUND_EXCEPTION = "User not found!";

    public static final String EMAIL_EXCEPTION = "Email is not valid!";
}
