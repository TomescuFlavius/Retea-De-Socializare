package app.followers.services;

import app.followers.models.Follower;
import java.util.List;

public interface FollowerQueryService {
    List<Follower> getAllFollowers();
    int followersCounter(int id);
}
