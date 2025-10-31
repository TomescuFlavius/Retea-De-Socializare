package app.likes.services;

import app.likes.models.Like;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LikeQueryServiceImpl implements LikeQueryService {
    private File file;
    private List<Like> likes;

    public LikeQueryServiceImpl(){
        file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\likes\\repository\\like.txt");
        likes=new ArrayList<>();
        loadLikes();
    }

    public void loadLikes(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.likes.add(new Like(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Like> getAllLikes() {
        return this.likes;
    }

    @Override
    public int likeCounter(int id){
        int ct=0;
        for (Like like:likes){
            if (like.getUserId()==id){
                ct++;
            }
        }
        return ct;
    }
    
    @Override
    public int likesByPhotoId(int id){
        int ct=0;
        for(Like like: likes){
            if (like.getPhotoId()==id){
                ct++;
            }
        }
        return ct;
    }

    @Override
    public Like getLikeByPhotoId(int id) {
        for (Like like: likes){
            if (like.getPhotoId()==id){
                return like;
            }
        }
        return null;
    }

}
