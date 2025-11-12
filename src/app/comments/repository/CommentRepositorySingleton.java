package app.comments.repository;

public class CommentRepositorySingleton {
    private static class LazyHolder{
        private static final CommentRepository COMMENT_REPOSITORY= new CommentRepositoryImpl();
    }
    public static CommentRepository getInstance(){
        return LazyHolder.COMMENT_REPOSITORY;
    }
}
