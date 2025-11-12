package app.likes.repository;

import app.likes.models.Like;

import java.util.List;

public interface LikeRepository {

    Like add(Like like);
    Like delete(Like like);
    List<Like> getAllLikes();
    int likeCounter(int id);
    int likesByPhotoId(int id);
    Like getLikeByPhotoId(int id);
}
