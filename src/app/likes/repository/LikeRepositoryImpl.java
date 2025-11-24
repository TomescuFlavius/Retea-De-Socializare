package app.likes.repository;

import app.likes.models.Like;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LikeRepositoryImpl implements LikeRepository {

    private File file;
    private List<Like> likes;

    public LikeRepositoryImpl(){
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
    public Like add(Like like) {
        likes.add(like);
        saveLikes();
        return like;
    }

    @Override
    public Like delete(Like like) {
        likes.remove(like);
        saveLikes();
        return like;
    }

    @Override
    public List<Like> getAllLikes() {
        return this.likes;
    }

    @Override
    public int likeCounter(int id) {
        return (int) likes.stream()
                .filter(like -> like.getUserId() == id)
                .count();
    }

    @Override
    public int likesByPhotoId(int id) {
        return (int) likes.stream()
                .filter(like -> like.getPhotoId() == id)
                .count();
    }

    @Override
    public Like getLikeByPhotoId(int id) {
        return likes.stream()
                .filter(like -> like.getPhotoId() == id)
                .findFirst()
                .orElse(null);
    }
}
