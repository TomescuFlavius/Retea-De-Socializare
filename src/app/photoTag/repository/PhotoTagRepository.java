package app.photoTag.repository;

import app.photos.models.PhotoTag;

import java.util.List;

public interface PhotoTagRepository {
    PhotoTag add(PhotoTag photoTag);
    PhotoTag delete(PhotoTag photoTag);
    List<PhotoTag> getTagsByPhotoId(int photoId);
    List<PhotoTag> getPhotosByTagId(int tagId);
}