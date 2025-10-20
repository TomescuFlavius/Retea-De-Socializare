package app.comments.services;



public class CommentQueryServiceSingleton {
    private static class LazyHolder{
        private static final CommentQueryService COMMENT_QUERY_SERVICE=new CommentQueryServiceImpl();
    }
    public static CommentQueryService getInstance(){
        return LazyHolder.COMMENT_QUERY_SERVICE;
    }
}
