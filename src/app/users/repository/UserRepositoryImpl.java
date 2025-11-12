package app.users.repository;

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

public class UserRepositoryImpl implements UserRepository {
    private List<User> users;
    private File file;

    private UserRepository userRepository;

    public UserRepositoryImpl(){
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

    @Override
    public User getUserByUsername(String username) {
        for (User user:users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public String toString(){
        String text="";
        int i;
        for (i=0;i<users.size()-1;i++){
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

    @Override
    public User getUserById(int id){
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

    public User add(User user)  {
        user.setId(generateId());
        users.add(user);
        saveUsers();
        return user;
    }

    @Override
    public User delete(User user) {
        users.remove(user);
        saveUsers();
        return user;
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    @Override
    public List<User> getAllUsersById(List<Integer> userIds) {
        List<User> goodUsers=new ArrayList<>();
        for (int i=0;i<users.size();i++){
            if(userIds.contains(users.get(i).getId())){
                goodUsers.add(users.get(i));
            }
        }
        return goodUsers;
    }

    @Override
    public List<User> showUsers() {
        return users;
    }

    @Override
    public User getUserByName(String name) {
        for (User user : users){
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public int getIdByUsername(String name) {
        for (User user:users){
            if (user.getUsername().equals(name)){
                return user.getId();
            }
        }
        return -1;
    }

    @Override
    public String getUsernameById(int id) {
        for (User user:users){
            if (user.getId()==id){
                return user.getUsername();
            }
        }
        return null;
    }


}
