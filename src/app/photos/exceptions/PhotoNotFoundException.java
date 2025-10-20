package app.photos.exceptions;

import static app.system.constants.ExceptionsConstants.PHOTO_NOT_FOUND_EXCEPTION;

public class PhotoNotFoundException extends Exception {
    public PhotoNotFoundException() {super(PHOTO_NOT_FOUND_EXCEPTION);}
}
