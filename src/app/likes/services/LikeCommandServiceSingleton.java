package app.likes.services;

public class LikeCommandServiceSingleton {
    private static class LazyHolder{
        private static final LikeCommandService LIKE_COMMAND_SERVICE=new LikeCommandServiceImpl();
    }
    public static LikeCommandService getInstance(){
        return LazyHolder.LIKE_COMMAND_SERVICE;
    }
}
