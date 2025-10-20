package app.users.services;

import app.photos.models.Photo;
import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserNotFoundException;
import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserCommandServiceImpl implements UserCommandService {
    private List<User> users;
    private File file;

    public UserCommandServiceImpl(){
        users=new ArrayList<>();
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\users\\repository\\users.txt");
        this.loadUsers();
    }

    public void loadUsers(){
        try {
            Scanner scanner= new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                switch (line.split(",")[0]){
                 case "ADMIN"->this.users.add(new Admin(line));
                 case "CLIENT"->this.users.add(new Client(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        String text="";
        int i;
        for (i=0;i<users.size();i++){
            User user=users.get(i);
            text+=user.toString()+"\n";
        }
        return users.get(i).toString()+"\n";
    }

    public  void saveUsers(){
        try (PrintWriter writer=new PrintWriter(new FileWriter(file))){
            writer.print(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private User getUserById(int id){
        for(User user: users){
            if (user.getId()==id){
                return user;
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
        while (getUserById(id)!=null){
            id=RandomId();
        }
        return id;
    }

    @Override
    public User add(User user) throws UserAlreadyExistException {
        for(User user1: users){
            if (user1.equals(user)){
                throw new UserAlreadyExistException();
            }
        }
        user.setId(generateId());
        users.add(user);
        saveUsers();
        return user;
    }

    @Override
    public User deleteUser(User user) throws UserNotFoundException {
        if (!users.contains(user)){
            throw new UserNotFoundException();
        }
        users.remove(user);
        saveUsers();
        return user;
    }
}
