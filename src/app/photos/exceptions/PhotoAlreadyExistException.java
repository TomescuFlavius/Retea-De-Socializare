package app.photos.exceptions;

import static app.system.constants.ExceptionsConstants.PHOTO_ALREADY_EXIST_EXCEPTION;

public class PhotoAlreadyExistException extends Exception {
    public PhotoAlreadyExistException() {
        super(PHOTO_ALREADY_EXIST_EXCEPTION);
    }
}
