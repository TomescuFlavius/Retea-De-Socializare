package app.service;

import app.users.Admin;
import app.users.Client;
import app.users.User;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserCommandServiceImpl {
    private List<User> users;
    private File file;

    public UserCommandServiceImpl(){
        users=new ArrayList<>();
        this.file=new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\users\\Users.txt");
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
}
