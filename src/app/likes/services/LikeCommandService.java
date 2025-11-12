package app.likes.services;

import app.likes.exceptions.YouAlreadyLikedThePhotoException;
import app.likes.models.Like;

public interface LikeCommandService {
    Like add(Like like) throws YouAlreadyLikedThePhotoException;

}
