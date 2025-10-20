package app.comments.services;

import app.comments.exceptions.CommentAlreadyExistException;
import app.comments.exceptions.CommentNotFoundException;
import app.comments.models.Comment;

public interface CommentCommandService {
    Comment add(Comment comment) throws CommentAlreadyExistException;
    Comment delete(Comment comment) throws CommentNotFoundException;
    Comment edit(Comment comment);
}
