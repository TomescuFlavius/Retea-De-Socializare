package app.followers.services;

import app.followers.models.Follower;

public interface FollowerCommandService {
    Follower add(Follower follower);
    Follower delete(Follower follower);
}
