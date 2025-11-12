package app.photos.services;

import app.photos.exceptions.PhotoNotFoundException;
import app.photos.models.Photo;
import app.photos.repository.PhotoRepository;
import app.photos.repository.PhotoRepositorySingleton;

public class PhotoCommandServiceImpl implements PhotoCommandService {
    private PhotoRepository photoRepository;

    public PhotoCommandServiceImpl(){
        this.photoRepository= PhotoRepositorySingleton.getInstance();
    }

    @Override
    public Photo delete(Photo photo) throws PhotoNotFoundException {
        if (photoRepository.getPhotoById(photo.getId())==null){
            throw new PhotoNotFoundException();
        }
        return photoRepository.delete(photo);
    }
}
