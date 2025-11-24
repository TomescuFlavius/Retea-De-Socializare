package app.users.models;

import app.users.Permissions;
import app.users.UserPermissions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User implements Comparable<User>, UserPermissions {
    protected int id;
    protected String username;
    protected String password;
    protected LocalDate createdAt;
    protected List<Permissions> permissions;

    public User(int id){
        this.id=id;
    }

    public User(String text) {
        String[] properties= text.split(",");
        this.id = Integer.parseInt(properties[1]);
        this.username = properties[2];
        this.password = properties[3];
        this.createdAt = LocalDate.parse(properties[4],DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String[] permisiuni=properties[5].split(";");
        this.permissions=new ArrayList<>();
         for(String permision :permisiuni){
             this.permissions.add(Permissions.valueOf(permision));
         }
        }

    public User(int id, String username, String password, LocalDate createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdAt = LocalDate.parse(createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        this.permissions = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public List<Permissions> getPermissions() {
        return this.permissions;
    }

    @Override
    public void addPermission(Permissions permissions) {

    }

    @Override
    public void erasePermission(Permissions permissions) {

    }

    @Override
    public String toString() {
        return  id + "," + username + "," +password + "," + createdAt+","+permissions;
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return ((User) o).id == user.id && ((User) o).username == user.username && ((User) o).createdAt == user.createdAt;
    }

    public  int compareTo(User o){
        if (this.getId()>o.getId()){
            return 1;
        }
        else if (this.getId()<o.getId()){
            return -1;
        }
        return 0;
    }
}