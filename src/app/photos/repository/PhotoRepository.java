package app.photos.repository;

import app.photos.models.Photo;

import java.util.List;

public interface PhotoRepository {
    Photo add(Photo photo) ;
    Photo delete(Photo photo);
    List<Photo> getAllPhotos();
    List<Photo> getPhotosByUserId(int id);
    Photo getPhotoById(int id);
}
