package app.exceptions;

import static app.system.ExceptionsConstants.USER_ALREADY_EXIST_EXCEPTION;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException() {
        super(USER_ALREADY_EXIST_EXCEPTION);
    }
}
