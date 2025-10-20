package app.tags.services;

import app.tags.models.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TagQueryServiceImpl implements TagQueryService{

    private File file;
    private List<Tag> tags;

    public TagQueryServiceImpl(){
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\tags\\repository\\tag.txt");
        this.tags=new ArrayList<>();
        this.loadTags();
    }


    public void loadTags(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String line= scanner.nextLine();
                tags.add(new Tag(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }







    @Override
    public List<Tag> getAllTags() {
        return this.tags;
    }
}
