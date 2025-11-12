package app.followers.services;

import app.followers.repository.FollowerRepository;
import app.followers.repository.FollowerRepositorySingleton;

public class FollowerCommandServiceImpl implements FollowerCommandService {

    private FollowerRepository followerRepository;

    public FollowerCommandServiceImpl() {
        followerRepository = FollowerRepositorySingleton.getInstance();
    }

}