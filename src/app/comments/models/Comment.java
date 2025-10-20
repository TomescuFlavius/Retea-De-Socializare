package app.comments.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private int id;
    private int photoId;
    private int userId;
    private LocalDateTime createdAt;
    private String commentText;

    public Comment(int id, int photoId, int userId, LocalDateTime createdAt, String commentText) {
        this.id = id;
        this.photoId = photoId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.commentText = commentText;
    }

    public Comment(String text) {
        String[] properties = text.split(",");
        this.id = Integer.parseInt(properties[0]);
        this.photoId = Integer.parseInt(properties[1]);
        this.userId = Integer.parseInt(properties[2]);
        this.createdAt = LocalDateTime.parse(properties[3], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.commentText = properties[4];
    }

    public Comment(Builder builder) {
        this.id = builder.id;
        this.photoId = builder.photoId;
        this.userId = builder.userId;
        this.createdAt = builder.createdAt;
        this.commentText = builder.commentText;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private int photoId;
        private int userId;
        private LocalDateTime createdAt;
        private String commentText;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder photoId(int photoId) {
            this.photoId = photoId;
            return this;
        }

        public Builder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder commentText(String commentText) {
            this.commentText = commentText;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }

    public int getId() {
        return id;
    }

    public int getPhotoId() {
        return photoId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return id + "," + photoId + "," + userId + "," +
                createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "," + commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return id == comment.id && photoId == comment.photoId && userId == comment.userId;
    }
}
