package app.comments.services;

import app.comments.exceptions.CommentNotFoundException;
import app.comments.models.Comment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CommentCommandServiceImpl implements CommentCommandService {

    private List<Comment> comments;
    private File file;

    public CommentCommandServiceImpl(){
        comments=new ArrayList<>();
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\comments\\repository\\comments.txt");
        this.loadComments();
    }

    public void loadComments(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String  line = scanner.nextLine();
                this.comments.add(new Comment(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }






    public String toString(){
        String text="";
        int i;
        for (i=0;i<comments.size()-1;i++){
            Comment comment= comments.get(i);
            text+=comment.toString()+"\n";
        }
        return comments.get(i).toString()+"\n";
    }

    public void saveComents(){
        try (PrintWriter writer=new PrintWriter(new FileWriter(file))){
            writer.print(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Comment getCommentById(int id){
        for (Comment comment: comments){
            if(comment.getId()==id){
                return comment;
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
        int id= RandomId();
        while (getCommentById(id)!=null){
            id=RandomId();
        }
        return id;
    }

    @Override
    public Comment add(Comment comment) {

        comment.setId(generateId());
        comments.add(comment);
        saveComents();
        return comment;
    }

    @Override
    public Comment delete(Comment comment) throws CommentNotFoundException {
        if (!comments.contains(comment)){
            throw new CommentNotFoundException();
        }
        comments.remove(comment);
        saveComents();
        return comment;
    }

    @Override
    public Comment edit(Comment comment) {
        return null;
    }
}
