package app.followers.services;

public class FollowerQueryServiceSingleton {
    private static class LazyHolder{
        private static final FollowerQueryService FOLLOWER_QUERY_SERVICE = new FollowerQueryServiceImpl();

    }

    public static FollowerQueryService getInstance(){
        return LazyHolder.FOLLOWER_QUERY_SERVICE;
    }
}
