package app.comments.services;

import app.comments.models.Comment;

import java.util.List;

public interface CommentQueryService {
    List<Comment> getAllComments();
    List<Comment> afisareComentariiByUserId(int id);
}
