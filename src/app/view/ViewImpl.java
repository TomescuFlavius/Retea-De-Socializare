package app.view;

import app.comments.services.*;
import app.photos.services.PhotoCommandService;
import app.photos.services.PhotoCommandServiceSingleton;
import app.photos.services.PhotoQueryService;
import app.photos.services.PhotoQueryServiceSingleton;
import app.tags.models.Tag;
import app.tags.services.*;
import app.users.models.User;
import app.users.services.UserCommandService;
import app.users.services.UserCommandServiceSingleton;
import app.users.services.UserQueryService;
import app.users.services.UserQueryServiceSingleton;


import java.util.Scanner;

public class ViewImpl implements View{

   UserCommandService userCommandService;
   UserQueryService userQueryService;
   TagCommandService tagCommandService;
   TagQueryService tagQueryService;
   PhotoCommandService photoCommandService;
   PhotoQueryService photoQueryService;
   CommentQueryService commentQueryService;
   CommentCommandService commentCommandService;
   Scanner scanner;

   public ViewImpl(){
       this.userCommandService= UserCommandServiceSingleton.getInstance();
       this.userQueryService= UserQueryServiceSingleton.getInstance();
       this.commentCommandService = CommentCommandServiceSingleton.getInstance();
       this.tagCommandService= TagCommandServiceSingleton.getInstance();
       this.tagQueryService= TagQueryServiceSingleton.getInstance();
       scanner=new Scanner(System.in);


       this.play();

   }

   public void meniu(){
       System.out.println("1.Afisare useri");
       System.out.println("2.Afisare admini");
   }


   @Override
    public void play() {
       meniu();
        boolean run=true;
        while (run){
            int alegere=Integer.parseInt(scanner.nextLine());
        switch (alegere){
            case 1:
                showUsers();
                break;
            case 2:
                showAdmins();
                break;
            case 3:
                showUsers();
                break;
            }
        }

    }

    public void showUsers(){
        System.out.println(userQueryService.showUsers());
    }

    public void showAdmins(){
        System.out.println(userQueryService.showAdmins());
    }
}
