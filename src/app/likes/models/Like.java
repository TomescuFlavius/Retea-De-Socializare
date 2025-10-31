package app.likes.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Like implements Comparable {
    int userId;
    int photoId;
    LocalDate createdAt;

    public Like(int userId, int photoId, LocalDate createdAt){
        this.userId = userId;
        this.photoId = photoId;
        this.createdAt = createdAt;
    }

    public Like(String text){
        String[] properties = text.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.userId = Integer.parseInt(properties[0]);
        this.photoId = Integer.parseInt(properties[1]);
        this.createdAt = LocalDate.parse(properties[2], formatter);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString(){
        return userId + "," + photoId + "," + createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public boolean equals(Object o){
        Like like = (Like) o;
        return userId == like.userId && photoId == like.photoId;
    }

    @Override
    public int compareTo(Object o) {
        Like other = (Like) o;
        if (other.createdAt.isBefore(this.createdAt)){
            return 1;
        }
        else if (other.createdAt.isAfter(this.createdAt)){
            return -1;
        }
        return 0;
    }


}