package app.comments.exceptions;

import static app.system.constants.ExceptionsConstants.COMMENT_NOT_FOUND_EXCEPTION;

public class CommentNotFoundException extends Exception {
    public CommentNotFoundException() {
        super(COMMENT_NOT_FOUND_EXCEPTION);
    }
}
