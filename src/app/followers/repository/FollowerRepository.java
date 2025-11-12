package app.followers.repository;

import app.followers.models.Follower;

import java.util.List;

public interface FollowerRepository {
    Follower add(Follower follower);
    Follower delete(Follower follower);
    List<Follower> getAllFollowers();
    int followersCounter(int id);
}
