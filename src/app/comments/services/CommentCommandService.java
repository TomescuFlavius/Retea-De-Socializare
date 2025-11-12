package app.comments.services;
import app.comments.exceptions.CommentNotFoundException;
import app.comments.models.Comment;



public interface CommentCommandService {
    Comment delete(Comment comment) throws CommentNotFoundException;
}
