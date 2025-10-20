package app.photoTags.models;

public class PhotoTag {
    int photoId;
    int tagId;

    public PhotoTag(int photoId, int tagId){
        this.photoId=photoId;
        this.tagId=tagId;
    }

    public PhotoTag(String text){
        photoId=Integer.parseInt(text.split(",")[0]);
        tagId=Integer.parseInt(text.split(",")[1]);
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

    @Override
    public String toString(){
        return photoId + "," +tagId;
    }
}
