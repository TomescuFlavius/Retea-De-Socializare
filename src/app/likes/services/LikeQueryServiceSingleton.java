package app.likes.services;

public class LikeQueryServiceSingleton {
    private static class LazyHolder{
        private static final LikeQueryService LIKE_QUERY_SERVICE=new LikeQueryServiceImpl();

    }

    public static LikeQueryService getInstance(){
        return LazyHolder.LIKE_QUERY_SERVICE;
    }
}
