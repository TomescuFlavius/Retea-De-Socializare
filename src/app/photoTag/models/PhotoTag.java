package app.photos.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PhotoTag implements Comparable<PhotoTag> {
    int photoId;
    int tagId;
    LocalDate createdAt;

    public PhotoTag(int photoId, int tagId, LocalDate createdAt) {
        this.photoId = photoId;
        this.tagId = tagId;
        this.createdAt = createdAt;
    }

    public PhotoTag(String text) {
        String[] properties = text.split(",");
        this.photoId = Integer.parseInt(properties[0]);
        this.tagId = Integer.parseInt(properties[1]);
        this.createdAt = LocalDate.parse(properties[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return photoId + "," + tagId + "," + createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoTag photoTag = (PhotoTag) o;
        return photoId == photoTag.photoId && tagId == photoTag.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, tagId);
    }

    @Override
    public int compareTo(PhotoTag o) {
        return o.createdAt.compareTo(this.createdAt);
    }
}