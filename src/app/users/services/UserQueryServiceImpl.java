package app.users.services;

import app.users.Permissions;
import app.users.exceptions.UserNotFoundException;
import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserQueryServiceImpl implements UserQueryService {
    private File file;
    private List<User> users;
    public UserQueryServiceImpl(){
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\users\\repository\\users.txt");
        this.users=new ArrayList<>();
        this.loadUsers();
    }

    public void loadUsers(){
        try {
            Scanner scanner =new Scanner(file);
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();

                switch (line.split(",")[0]){
                    case "ADMIN"->this.users.add(new Admin(line));
                    case "CLIENT"-> this.users.add(new Client(line));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException{
        for(int i=0;i<users.size();i++){
            if (id==users.get(i).getId()){
                return users.get(i);
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public List<User> getAllUsersByIds(List<Integer> userIds){
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
    public List<Admin> showAdmins() {
        return null;
    }


}
