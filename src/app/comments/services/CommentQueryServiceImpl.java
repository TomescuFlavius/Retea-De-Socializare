package app.comments.services;

import app.comments.repository.CommentRepository;
import app.comments.repository.CommentRepositorySingleton;

public class CommentQueryServiceImpl implements CommentQueryService{

    private CommentRepository commentRepository;
    public CommentQueryServiceImpl(){
        this.commentRepository= CommentRepositorySingleton.getInstance();
    }


}
