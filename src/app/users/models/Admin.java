package app.users.models;

import app.users.Permissions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Admin extends User {

    private double salary;
    private LocalDate dateOfEmploy;


    public Admin(int id, String username, String password, LocalDate createdAt, double salary, LocalDate dateOfEmploy) {
        super(id, username, password, createdAt);
        this.dateOfEmploy = dateOfEmploy;
        this.salary = salary;
        this.addPermission(Permissions.USER_READ);
        this.addPermission(Permissions.USER_CREATE);
    }

    public Admin(String text){
        super(text);
        String[] properties= text.split(",");
        this.salary=Double.parseDouble(text.split(",")[6]);
        this.dateOfEmploy=LocalDate.parse(text.split(",")[7],DateTimeFormatter.ofPattern("yyyy-MM-dd"));


    }


    private Admin(Builder builder){
        super(builder.id, builder.username, builder.password, builder.createdAt);
        this.dateOfEmploy=builder.dateOfEmployee;
        this.salary=builder.salary;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int id;
        private String username;
        private String password;
        private LocalDate createdAt;
        private double salary;
        private LocalDate dateOfEmployee;

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

        public Builder salary(double salary){
            this.salary=salary;
            return this;
        }

        public Builder dateOfEmployee(LocalDate dateOfEmployee){
            this.dateOfEmployee=dateOfEmployee;
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }
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
    public int compareTo(User o) {
        if (o.getCreatedAt().isAfter(getCreatedAt())) {
            return 1;
        } else if (o.getCreatedAt().isBefore(getCreatedAt())) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return getId() + "," + getUsername() + "," + getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
                "," + salary+ "," + dateOfEmploy.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "," + permissions;
    }

    @Override
    public boolean equals(Object o) {
        Admin admin = (Admin) o;
        return admin.id == ((Admin) o).getId() && admin.username == ((Admin) o).getUsername();
    }
}

