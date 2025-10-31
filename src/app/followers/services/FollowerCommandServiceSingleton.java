package app.followers.services;

public class FollowerCommandServiceSingleton {
    private static class LazyHolder{
        private static final FollowerCommandService FOLLOWER_COMMAND_SERVICE = new FollowerCommandServiceImpl();
    }
    public static FollowerCommandService getInstance(){
        return LazyHolder.FOLLOWER_COMMAND_SERVICE;
    }
}
