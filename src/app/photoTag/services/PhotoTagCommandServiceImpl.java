package app.photoTag.services;

import app.photos.models.PhotoTag;
import app.photoTag.repository.PhotoTagRepository;
import app.photoTag.repository.PhotoTagRepositorySingleton;

public class PhotoTagCommandServiceImpl implements PhotoTagCommandService {

    private final PhotoTagRepository photoTagRepository;

    public PhotoTagCommandServiceImpl(){
        this.photoTagRepository = PhotoTagRepositorySingleton.getInstance();
    }

    @Override
    public PhotoTag add(PhotoTag photoTag) {
        return photoTagRepository.add(photoTag);
    }

    @Override
    public PhotoTag delete(PhotoTag photoTag) {
        return photoTagRepository.delete(photoTag);
    }
}