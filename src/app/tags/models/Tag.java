package app.tags.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tag implements Comparable{
    int id;
    String tagName;
    LocalDate createdAt;

    public Tag(int id, String tagName, LocalDate createdAt){
        this.id=id;
        this.tagName=tagName;
        this.createdAt=createdAt;
    }

    public Tag(String text){
        String [] prop= text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.tagName=prop[1];
        this.createdAt=LocalDate.parse(prop[2]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString(){
        return id+","+tagName+","+createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
