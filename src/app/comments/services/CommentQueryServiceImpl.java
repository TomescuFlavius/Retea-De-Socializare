package app.comments.services;

import app.comments.models.Comment;

import java.util.List;

public class CommentQueryServiceImpl implements CommentQueryService{
    @Override
    public List<Comment> getAllComments() {
        return List.of();
    }
}
