package app.users.exceptions;

import static app.system.constants.ExceptionsConstants.USER_NOT_FOUND_EXCEPTION;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super(USER_NOT_FOUND_EXCEPTION);
    }
}
