package app.photos.services;

import app.photos.exceptions.PhotoAlreadyExistException;
import app.photos.exceptions.PhotoNotFoundException;
import app.photos.models.Photo;

public interface PhotoCommandService {
    Photo add(Photo photo) throws PhotoAlreadyExistException;
    Photo delete(Photo photo) throws PhotoNotFoundException;
}
