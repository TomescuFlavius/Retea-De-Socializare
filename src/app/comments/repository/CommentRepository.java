package app.comments.repository;

import app.comments.models.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> getAllComments();
    List<Comment> afisareComentariiByUserId(int id);
    Comment add(Comment comment);
    Comment delete(Comment comment);
    Comment getCommentById(int id);
}
