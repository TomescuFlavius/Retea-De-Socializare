package app.comments.services;

import app.comments.exceptions.CommentNotFoundException;
import app.comments.models.Comment;
import app.comments.repository.CommentRepository;
import app.comments.repository.CommentRepositorySingleton;

public class CommentCommandServiceImpl implements CommentCommandService {

    private CommentRepository commentRepository;

    public CommentCommandServiceImpl(){
        this.commentRepository= CommentRepositorySingleton.getInstance();
    }

    @Override
    public Comment delete(Comment comment) throws CommentNotFoundException {
        if (commentRepository.getCommentById(comment.getId())==null){
            throw new CommentNotFoundException();
        }
        return commentRepository.delete(comment);
    }

}
