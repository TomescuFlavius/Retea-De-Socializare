package app.users.models;

import app.users.Permissions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client extends User {
    private boolean activ;

    public Client(int id, String username, String password, LocalDate createdAt, boolean activ){
        super(id,username,password,createdAt);
        this.activ=activ;
    }

    public Client(String text){
        super(text);
        String[] properties= text.split(",");
        this.activ=Boolean.parseBoolean(text.split(",")[5]);
    }

    public Client(Builder builder){
        super(builder.id, builder.username, builder.password, builder.createdAt);
        this.activ=builder.activ;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        public boolean activ;
        private int id;
        private String username;
        private String password;
        private LocalDate createdAt;


        public Builder id(int id){
            this.id=id;
            return this;
        }

        public Builder username(String username){
            this.username=username;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public Builder createdAt(LocalDate createdAt){
            this.createdAt=createdAt;
            return this;
        }

        public Builder activ(boolean activ){
            this.activ=activ;
            return this;
        }

        public Client build(){
            return new Client(this);
        }

    }

    @Override
    public int compareTo(User o) {
        if (o.getCreatedAt().isAfter(getCreatedAt())) {
            return 1;
        } else if (o.getCreatedAt().isBefore(getCreatedAt())) {
            return -1;
        } else return 0;
    }

    @Override
    public void addPermission(Permissions permissions) {
        this.permissions.add(permissions);
    }

    @Override
    public void erasePermission(Permissions permissions) {
        this.permissions.remove(permissions);
    }

    @Override
    public String toString(){
        return getId()+ ","+ getUsername()+ ","+password+","+
                getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                +","+permissions+","+ activ + "\n";
    }

    @Override
    public boolean equals(Object o){
        Client client=(Client) o;
        return client.id==((Client) o).id && client.username==((Client) o).username;
    }
}
