package app.tags.services;

public class TagQueryServiceSingleton {
    private static class LazyHolder{
        private static final TagQueryService TAG_QUERY_SERVICE= new TagQueryServiceImpl();
    }
    public static TagQueryService getInstance(){
        return LazyHolder.TAG_QUERY_SERVICE;
    }
}
