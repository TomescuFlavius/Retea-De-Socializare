package app.photoTag.services;

public class PhotoTagCommandServiceSingleton {
    private static class LazyHolder{
        private static final PhotoTagCommandService PHOTO_TAG_COMMAND_SERVICE = new PhotoTagCommandServiceImpl();
    }
    public static PhotoTagCommandService getInstance(){
        return LazyHolder.PHOTO_TAG_COMMAND_SERVICE;
    }
}