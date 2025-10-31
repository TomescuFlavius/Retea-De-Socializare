package app.comments.services;

import app.comments.models.Comment;

import java.io.File;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommentQueryServiceImpl implements CommentQueryService{

    private File file;
    private List<Comment> comments;
    public CommentQueryServiceImpl(){
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\comments\\repository\\comments.txt");
        this.comments=new ArrayList<>();
        this.loadComments();
    }

    public void loadComments(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String line= scanner.nextLine();
                comments.add(new Comment(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return this.comments;
    }

    @Override
    public List<Comment> afisareComentariiByUserId(int id) {
        List<Comment> comments1=new ArrayList<>();
        for (Comment comment:comments){
            if (comment.getUserId()==id){
                comments1.add(comment);
            }
        }
        return comments1;
    }
}
