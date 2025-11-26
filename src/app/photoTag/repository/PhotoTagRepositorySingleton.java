package app.photoTag.repository;


public class PhotoTagRepositorySingleton {
    private static class LazyHolder{
        private static final PhotoTagRepository PHOTO_TAG_REPOSITORY = new PhotoTagRepositoryImpl();
    }
    public static PhotoTagRepository getInstance(){
        return LazyHolder.PHOTO_TAG_REPOSITORY;
    }
}