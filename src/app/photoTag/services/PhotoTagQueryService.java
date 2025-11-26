package app.photoTag.services;

import app.photos.models.PhotoTag;
import java.util.List;

public interface PhotoTagQueryService {
    List<PhotoTag> getTagsByPhotoId(int photoId);
    List<PhotoTag> getPhotosByTagId(int tagId);
}