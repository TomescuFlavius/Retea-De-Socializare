package app.comments.exceptions;

import static app.system.constants.ExceptionsConstants.COMMENT_ALREADY_EXIST_EXCEPTION;

public class CommentAlreadyExistException extends Exception {
    public CommentAlreadyExistException() {
        super(COMMENT_ALREADY_EXIST_EXCEPTION);
    }
}
