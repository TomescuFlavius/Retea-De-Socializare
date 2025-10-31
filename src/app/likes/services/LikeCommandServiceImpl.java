package app.likes.services;

import app.likes.exceptions.YouAlreadyLikedThePhotoException;
import app.likes.models.Like;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LikeCommandServiceImpl implements LikeCommandService {

    private File file;
    private List<Like> likes;

    public LikeCommandServiceImpl(){
        file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\likes\\repository\\like.txt");
        likes=new ArrayList<>();
        loadLikes();
    }

    public void loadLikes(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                likes.add(new Like(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String text="";
        int i;
        for(i=0;i<likes.size()-1;i++) {
            Like like = likes.get(i);
            text += like.toString() + "\n";
        }
        text+= likes.get(i).toString();
        return text;
    }

    public void saveLikes(){
        try (PrintWriter writer=new PrintWriter(new FileWriter(this.file))){
            writer.print(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public Like add(Like like)  throws YouAlreadyLikedThePhotoException {
            for (Like like1: likes){
                if (like1.getUserId() == like.getUserId() && like1.getPhotoId()==like.getPhotoId()){
                    throw new YouAlreadyLikedThePhotoException();
                }
            }
        likes.add(like);
        saveLikes();
        return like;
    }

    @Override
    public Like delete(Like like) {
        return null;
    }
}
