package app.followers.services;

import app.followers.models.Follower;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FollowerQueryServiceImpl implements FollowerQueryService {
    private File file;
    private List<Follower> followers;

    public FollowerQueryServiceImpl(){
        file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\followers\\repository\\follower.txt");
        followers=new ArrayList<>();
        loadFollowers();
    }

    public void loadFollowers(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.followers.add(new Follower(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Follower> getAllFollowers() {
        return this.followers;
    }

    @Override
    public int followersCounter(int id) {
        int ct=0;
        for (Follower follower:followers){
            if (follower.getFolloweeId()==id){
                ct++;
            }
        }
        return ct;
    }
}
