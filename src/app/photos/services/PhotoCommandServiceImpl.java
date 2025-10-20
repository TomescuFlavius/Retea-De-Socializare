package app.photos.services;

import app.photos.exceptions.PhotoAlreadyExistException;
import app.photos.exceptions.PhotoNotFoundException;
import app.photos.models.Photo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PhotoCommandServiceImpl implements PhotoCommandService {
    private File file;
    private List<Photo> photos;

    public PhotoCommandServiceImpl(){
        file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\photos\\repository\\photo.txt");
        photos=new ArrayList<>();
        loadPhotos();
    }

    public void loadPhotos(){
        try {
            Scanner scanner=new Scanner(System.in);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                photos.add(new Photo(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String text="";
        int i;
        for (i=0;i<photos.size();i++){
            Photo photo=photos.get(i);
            text+=photo.toString()+"\n";
        }
        return photos.get(i).toString()+"\n";
    }

    public  void savePhotos(){
        try (PrintWriter writer=new PrintWriter(new FileWriter(this.file))){
            writer.print(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Photo getPhotoById(int id){
        for(Photo photo: photos){
            if (photo.getId()==id){
                return photo;
            }
        }
        return null;
    }

    private int RandomId(){
        Random random=new Random();
        int id=random.nextInt(100)+1;
        return id;
    }

    private int generateId(){
        int id=RandomId();
        while (getPhotoById(id)!=null){
            id=RandomId();
        }
        return id;
    }

    @Override
    public Photo add(Photo photo) throws PhotoAlreadyExistException {
        for (Photo photo1:photos){
            if(photo1.equals(photo)){
                throw new  PhotoAlreadyExistException();
            }
        }
        photo.setId(generateId());
        photos.add(photo);
        savePhotos();
        return photo;
    }

    @Override
    public Photo delete(Photo photo) throws PhotoNotFoundException {
        if (!photos.contains(photo)){
            throw new PhotoNotFoundException();
        }
        photos.remove(photo);
        savePhotos();
        return photo;
    }
}
