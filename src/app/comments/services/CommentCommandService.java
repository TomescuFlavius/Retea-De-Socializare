package app.comments.services;

import app.comments.models.Comment;

public interface CommentCommandService {
    Comment add(Comment comment);
    Comment delete(Comment comment);
    Comment edit(Comment comment);
}
