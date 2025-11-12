package app.followers.services;

import app.followers.repository.FollowerRepository;
import app.followers.repository.FollowerRepositorySingleton;

public class FollowerQueryServiceImpl implements FollowerQueryService {
    private FollowerRepository followerRepository;

    public FollowerQueryServiceImpl(){
        this.followerRepository= FollowerRepositorySingleton.getInstance();
    }

}
