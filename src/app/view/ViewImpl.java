package app.view;

import app.users.services.UserCommandService;
import app.users.services.UserCommandServiceSingleton;
import app.users.services.UserQueryService;
import app.users.services.UserQueryServiceSingleton;


import java.util.Scanner;

public class ViewImpl implements View{

   UserCommandService userCommandService;
   UserQueryService userQueryService;
   Scanner scanner;

   public ViewImpl(){
       this.userCommandService= UserCommandServiceSingleton.getInstance();
       this.userQueryService= UserQueryServiceSingleton.getInstance();
       scanner=new Scanner(System.in);

        this.play();

   }

   public void meniu(){
       System.out.println("1.Afisare ADMINI");
       System.out.println("2.");
   }


   @Override
    public void play() {
        boolean run=true;
        while (run){
            int alegere=Integer.parseInt(scanner.nextLine());
        switch (alegere){
            case 1:
                break;
            case 2:
                break;
            }
        }

    }
}
