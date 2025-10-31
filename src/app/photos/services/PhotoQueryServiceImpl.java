package app.photos.services;


import app.photos.repository.PhotoRepository;
import app.photos.repository.PhotoRepositorySingleton;


public class PhotoQueryServiceImpl implements PhotoQueryService{

    private PhotoRepository photoRepository;


    public PhotoQueryServiceImpl(){
        photoRepository= PhotoRepositorySingleton.getInstance();
    }

}
