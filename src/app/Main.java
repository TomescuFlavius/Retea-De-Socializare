package app;

import app.users.models.Admin;
import app.users.models.Client;
import app.view.View;
import app.view.ViewAdmin;
import app.view.ViewClient;

public class Main {
    public static void main(String[] args) {

        Client client=new Client("CLIENT,11,Marian,parola1,2023-12-15,USER_CREATE;USER_READ,true");
        Admin admin= new Admin("ADMIN,10,Marian,parola1,2023-12-15,USER_CREATE;USER_DELETE;USER_UPDATE;USER_READ,2000.0,2022-10-10");
        View view= new ViewClient(client);
        View view1= new ViewAdmin(admin);
        view1.play();


    }
}