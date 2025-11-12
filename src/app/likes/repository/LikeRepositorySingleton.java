package app.likes.repository;

public class LikeRepositorySingleton {
    private static class LazyHolder{
        private static final LikeRepository LIKE_REPOSITORY=new LikeRepositoryImpl();
    }
    public static LikeRepository getInstance(){
        return LazyHolder.LIKE_REPOSITORY;
    }
}
