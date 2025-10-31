package app.followers.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Follower implements Comparable {
    int followerId;
    int followeeId;
    LocalDate createdAt;

    public Follower(int followerId, int followeeId, LocalDate createdAt){
        this.followerId = followerId;
        this.followeeId = followeeId;
        this.createdAt = createdAt;
    }

    public Follower(String text){
        String[] properties = text.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.followerId = Integer.parseInt(properties[0]);
        this.followeeId = Integer.parseInt(properties[1]);
        this.createdAt = LocalDate.parse(properties[2], formatter);
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(int followeeId) {
        this.followeeId = followeeId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString(){
        return followerId + "," + followeeId + "," + createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public boolean equals(Object o){
        Follower other = (Follower) o;
        return followerId == other.followerId && followeeId == other.followeeId;
    }

    @Override
    public int compareTo(Object o) {
        Follower other = (Follower) o;
        if (other.createdAt.isBefore(this.createdAt)){
            return 1;
        }
        else if (other.createdAt.isAfter(this.createdAt)){
            return -1;
        }
        return 0;
    }
}
