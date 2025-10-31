package app.likes.services;

import app.likes.models.Like;

import java.util.List;

public interface LikeQueryService {
    List<Like> getAllLikes();
    int likeCounter(int id);
    int likesByPhotoId(int id);
    Like getLikeByPhotoId(int id);
}
