package app.photoTag.services;

import app.photos.models.PhotoTag;

public interface PhotoTagCommandService {
    PhotoTag add(PhotoTag photoTag);
    PhotoTag delete(PhotoTag photoTag);
}