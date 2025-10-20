package app.photos.services;

import app.photos.models.Photo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhotoQueryServiceImpl implements PhotoQueryService{

    private File file;
    private List<Photo> photos;


    public PhotoQueryServiceImpl(){
        file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\photos\\repository\\photo.txt");
        photos=new ArrayList<>();
        this.loadPhotos();
    }

    public void loadPhotos(){
        try {
            Scanner scanner= new Scanner(System.in);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.photos.add(new Photo(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Photo> getAllPhotos() {
        return this.photos;
    }
}
