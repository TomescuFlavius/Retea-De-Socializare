package app.photos.services;

public class PhotoCommandServiceSingleton {
    private static class LazyHolder{
        private static final PhotoCommandService PHOTO_COMMAND_SERVICE=new PhotoCommandServiceImpl();
    }
    public static PhotoCommandService getInstance(){
        return LazyHolder.PHOTO_COMMAND_SERVICE;
    }
}
