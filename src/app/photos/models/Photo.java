package app.photos.models;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Photo implements Comparable {
    int id;
    int userId;
    String imageUrl;
    LocalDate createdAt;


    public Photo(int id, int userId, String imageUrl, LocalDate createdAt){
        this.id=id;
        this.userId=userId;
        this.imageUrl=imageUrl;
        this.createdAt=createdAt;
    }

    public Photo(String text){
        String[] properties=text.split(",");
        this.id=Integer.parseInt(properties[0]);
        this.userId=Integer.parseInt(properties[1]);
        this.imageUrl=properties[2];
        this.createdAt = LocalDate.parse(properties[4], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString(){
        return id + "," + userId+","+ imageUrl+ "," + createdAt;
    }

    @Override
    public boolean equals(Object o){
        Photo photo= (Photo) o;
        return photo.id==((Photo) o).id && photo.imageUrl==((Photo) o).imageUrl;
    }


    @Override
    public int compareTo(Object o) {
        Photo photo = (Photo) o;
        if (photo.createdAt.isBefore(((Photo) o).createdAt)){
            return 1;
        }
        else if (photo.createdAt.isAfter(((Photo) o).createdAt)){
            return -1;
        }
        return 0;
    }
}
