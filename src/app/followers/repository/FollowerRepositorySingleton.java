package app.followers.repository;

public class FollowerRepositorySingleton {
    private static class LazyHolder{
        private static final FollowerRepository FOLLOWER_REPOSITORY = new FollowerRepositoryImpl();
    }
    public static FollowerRepository getInstance(){
        return LazyHolder.FOLLOWER_REPOSITORY;
    }
}
