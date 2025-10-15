package app.exceptions;

import static app.system.ExceptionsConstants.USER_NOT_FOUND_EXCEPTION;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super(USER_NOT_FOUND_EXCEPTION);
    }
}
