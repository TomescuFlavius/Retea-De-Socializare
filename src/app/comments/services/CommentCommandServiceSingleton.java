package app.comments.services;

public class CommentCommandServiceSingleton {
    private static class LazyHolder{
        private static final CommentCommandService COMMENT_COMMAND_SERVICE= new CommentCommandServiceImpl();
    }
    public static CommentCommandService getInstance(){
        return LazyHolder.COMMENT_COMMAND_SERVICE;
    }
}
