package app.likes.services;

import app.likes.exceptions.YouAlreadyLikedThePhotoException;
import app.likes.models.Like;
import app.likes.repository.LikeRepository;
import app.likes.repository.LikeRepositorySingleton;

public class LikeCommandServiceImpl implements LikeCommandService {

    private LikeRepository likeRepository;

    public LikeCommandServiceImpl(){
        this.likeRepository= LikeRepositorySingleton.getInstance();
    }

    @Override
    public Like add(Like like)  throws YouAlreadyLikedThePhotoException {
            if(likeRepository.getLikeByPhotoId(like.getPhotoId())!=null){
                throw new YouAlreadyLikedThePhotoException();
            }
        return likeRepository.add(like);
    }

}
