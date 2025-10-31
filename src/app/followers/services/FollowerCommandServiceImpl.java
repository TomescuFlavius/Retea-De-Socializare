package app.followers.services;

import app.followers.models.Follower;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FollowerCommandServiceImpl implements FollowerCommandService {

    private File file;
    private List<Follower> followers;

    public FollowerCommandServiceImpl(){
        file = new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\followers\\repository\\follower.txt");
        followers = new ArrayList<>();
        loadFollowers();
    }

    public void loadFollowers(){
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                followers.add(new Follower(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String text = "";
        int i;
        for(i = 0; i < followers.size()-1; i++){
            Follower follower = followers.get(i);
            text += follower.toString() + "\n";
        }
        return followers.get(i).toString() + "\n";
    }

    public void saveFollowers(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.file))){
            writer.print(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public Follower add(Follower follower) {
        return null;
    }

    @Override
    public Follower delete(Follower follower) {
        return null;
    }
}
