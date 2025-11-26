package app.photoTag.services;

import app.photoTag.repository.PhotoTagRepository;
import app.photoTag.repository.PhotoTagRepositorySingleton;
import app.photos.models.PhotoTag;

import java.util.List;

public class PhotoTagQueryServiceImpl implements PhotoTagQueryService {

    private final PhotoTagRepository photoTagRepository;

    public PhotoTagQueryServiceImpl(){
        this.photoTagRepository = PhotoTagRepositorySingleton.getInstance();
    }

    @Override
    public List<PhotoTag> getTagsByPhotoId(int photoId) {
        return photoTagRepository.getTagsByPhotoId(photoId);
    }

    @Override
    public List<PhotoTag> getPhotosByTagId(int tagId) {
        return photoTagRepository.getPhotosByTagId(tagId);
    }
}