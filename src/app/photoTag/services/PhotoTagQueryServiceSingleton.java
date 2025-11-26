package app.photoTag.services;

public class PhotoTagQueryServiceSingleton {
    private static class LazyHolder{
        private static final PhotoTagQueryService PHOTO_TAG_QUERY_SERVICE = new PhotoTagQueryServiceImpl();
    }
    public static PhotoTagQueryService getInstance(){
        return LazyHolder.PHOTO_TAG_QUERY_SERVICE;
    }
}