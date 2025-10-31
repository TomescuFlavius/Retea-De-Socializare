package app.photos.repository;


public class PhotoRepositorySingleton {
    private static class LazyHolder{
        private static final PhotoRepository PHOTO_REPOSITOY=new PhotoRepositoryImpl();
    }
    public static PhotoRepository getInstance(){
        return LazyHolder.PHOTO_REPOSITOY;
    }
}
