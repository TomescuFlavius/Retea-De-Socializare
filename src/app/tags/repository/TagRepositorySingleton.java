package app.tags.repository;


public class TagRepositorySingleton {
    public static class LazyHolder{
        private static final TagRepository TAG_REPOSITORY=new TagRepositoryImpl();
    }
    public static TagRepository getInstance(){
        return TagRepositorySingleton.LazyHolder.TAG_REPOSITORY;
    }
}
