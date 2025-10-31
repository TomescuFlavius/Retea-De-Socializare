package app.likes.exceptions;

import static app.system.constants.ExceptionsConstants.YOU_ALREADY_LIKED_THE_PHOTO_EXCEPTION;

public class YouAlreadyLikedThePhotoException extends Exception {
    public YouAlreadyLikedThePhotoException() {
        super(YOU_ALREADY_LIKED_THE_PHOTO_EXCEPTION);
    }
}
