package app.photos.services;

import app.photos.exceptions.PhotoNotFoundException;
import app.photos.models.Photo;

public interface PhotoCommandService {
    Photo delete(Photo photo) throws PhotoNotFoundException;
}
