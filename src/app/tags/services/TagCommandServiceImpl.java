package app.tags.services;

import app.tags.models.Tag;
import app.users.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TagCommandServiceImpl implements TagCommandService {
    private List<Tag> tags;
    private File file;

    public TagCommandServiceImpl(){
        tags=new ArrayList<>();
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\tags\\repository\\tag.txt");
        this.loadTags();
    }

    public void loadTags(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String  line= scanner.nextLine();
                tags.add(new Tag(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String text="";
        int i;
        for (i=0;i<tags.size();i++){
            Tag tag=tags.get(i);
            text+=tag.toString()+"\n";
        }
        return tags.get(i).toString()+"\n";
    }


    public  void saveTags(){
        try (PrintWriter writer=new PrintWriter(new FileWriter(file))){
            writer.print(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Tag getTagById(int id){
        for(Tag tag: tags){
            if (tag.getId()==id){
                return tag;
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
        while (getTagById(id)!=null){
            id=RandomId();
        }
        return id;
    }


    @Override
    public Tag add(Tag tag) {
        tag.setId(generateId());
        tags.add(tag);
        saveTags();
        return tag;
    }

    @Override
    public Tag delete(Tag tag) {
        tags.remove(tag);
        saveTags();
        return tag;
    }
}
