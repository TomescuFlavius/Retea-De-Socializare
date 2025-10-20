package app.photos.services;

public class PhotoQueryServiceSingleton {
    private static class LazyHolder{
        private static final PhotoQueryService PHOTO_QUERY_SERVICE = new PhotoQueryServiceImpl();
    }
    public static PhotoQueryService getInstance(){
        return LazyHolder.PHOTO_QUERY_SERVICE;
    }
}
