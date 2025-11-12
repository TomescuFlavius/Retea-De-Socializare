package app.likes.services;

import app.likes.repository.LikeRepository;
import app.likes.repository.LikeRepositorySingleton;

public class LikeQueryServiceImpl implements LikeQueryService {
    private LikeRepository likeRepository;

    public LikeQueryServiceImpl(){
        this.likeRepository= LikeRepositorySingleton.getInstance();
    }


}
