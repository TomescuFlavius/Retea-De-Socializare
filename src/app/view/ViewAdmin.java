package app.view;

import app.comments.models.Comment;
import app.comments.repository.CommentRepository;
import app.comments.repository.CommentRepositorySingleton;
import app.comments.services.CommentCommandService;
import app.comments.services.CommentCommandServiceSingleton;
import app.comments.services.CommentQueryService;
import app.comments.services.CommentQueryServiceSingleton;
import app.followers.repository.FollowerRepository;
import app.followers.repository.FollowerRepositorySingleton;
import app.followers.services.FollowerCommandService;
import app.followers.services.FollowerCommandServiceSingleton;
import app.followers.services.FollowerQueryService;
import app.followers.services.FollowerQueryServiceSingleton;
import app.likes.exceptions.YouAlreadyLikedThePhotoException;
import app.likes.models.Like;
import app.likes.repository.LikeRepository;
import app.likes.repository.LikeRepositorySingleton;
import app.likes.services.LikeCommandService;
import app.likes.services.LikeCommandServiceSingleton;
import app.likes.services.LikeQueryService;
import app.likes.services.LikeQueryServiceSingleton;
import app.photos.models.Photo;
import app.photos.repository.PhotoRepository;
import app.photos.repository.PhotoRepositorySingleton;
import app.photos.services.PhotoCommandService;
import app.photos.services.PhotoCommandServiceSingleton;
import app.photos.services.PhotoQueryService;
import app.photos.services.PhotoQueryServiceSingleton;
import app.tags.services.TagCommandService;
import app.tags.services.TagCommandServiceSingleton;
import app.tags.services.TagQueryService;
import app.tags.services.TagQueryServiceSingleton;
import app.users.models.Admin;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;
import app.users.services.UserCommandService;
import app.users.services.UserCommandServiceSingleton;
import app.users.services.UserQueryService;
import app.users.services.UserQueryServiceSingleton;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ViewAdmin implements View{
    LikeQueryService likeQueryService;
    LikeCommandService likeCommandService;
    UserCommandService userCommandService;
    UserQueryService userQueryService;
    TagCommandService tagCommandService;
    TagQueryService tagQueryService;
    PhotoCommandService photoCommandService;
    PhotoQueryService photoQueryService;
    CommentQueryService commentQueryService;
    CommentCommandService commentCommandService;
    FollowerCommandService followerCommandService;
    FollowerQueryService followerQueryService;
    UserRepository userRepository;
    PhotoRepository photoRepository;
    LikeRepository likeRepository;
    FollowerRepository followerRepository;
    CommentRepository commentRepository;
    Scanner scanner;
    Admin admin;

    public ViewAdmin(Admin admin){

        this.userCommandService= UserCommandServiceSingleton.getInstance();
        this.userQueryService= UserQueryServiceSingleton.getInstance();
        this.tagCommandService= TagCommandServiceSingleton.getInstance();
        this.tagQueryService= TagQueryServiceSingleton.getInstance();
        this.likeQueryService= LikeQueryServiceSingleton.getInstance();
        this.likeCommandService= LikeCommandServiceSingleton.getInstance();
        this.photoCommandService= PhotoCommandServiceSingleton.getInstance();
        this.photoQueryService= PhotoQueryServiceSingleton.getInstance();
        this.commentQueryService= CommentQueryServiceSingleton.getInstance();
        this.commentCommandService= CommentCommandServiceSingleton.getInstance();
        this.followerCommandService= FollowerCommandServiceSingleton.getInstance();
        this.followerQueryService= FollowerQueryServiceSingleton.getInstance();
        this.userRepository= UserRepositorySingleton.getInstance();
        this.photoRepository= PhotoRepositorySingleton.getInstance();
        this.likeRepository= LikeRepositorySingleton.getInstance();
        this.followerRepository= FollowerRepositorySingleton.getInstance();
        this.commentRepository= CommentRepositorySingleton.getInstance();


        scanner=new Scanner(System.in);
        this.admin=admin;


        this.play();

    }

    public void meniu(){
        System.out.println("1.Afisare useri");
        System.out.println("2.Numarul total de like-uri");
        System.out.println("3.Afisati comentariile mele");
        System.out.println("4.Numar de followers");
        System.out.println("5.Numar de like-uri pentru o poza");
        System.out.println("6.Vizualizati pozele unei persoane");
        System.out.println("7.Apreciati o fotografie de pe profilul cuiva");
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
                    likeNumber();
                    break;
                case 3:
                    showComments();
                    break;
                case 4:
                    followersNumber();
                    break;
                case 5:
                    likesByPhotoId();
                    break;
                case 6:
                    showPhotosByUsername();
                    break;
                case 7:
                    likeAPhoto();
                    break;
            }
        }
    }

    public void showUsers(){
        List<User> userList =userRepository.showUsers();
        for (User user:userList){
            System.out.println(user.getUsername());
        }
    }

    public void likeNumber(){
        System.out.println("Numarul total de like-uri:  "+likeRepository.likeCounter(this.admin.getId()));
    }

    public void showComments(){
        List<Comment> comments=commentRepository.afisareComentariiByUserId(admin.getId());
        for (int i=0;i<comments.size();i++){
            System.out.println("Comentariu: "+comments.get(i).getCommentText()+"--> la poza:"+comments.get(i).getPhotoId());
        }
    }

    public void followersNumber(){
        System.out.println("Numar followers: "+followerRepository.followersCounter(admin.getId()));
    }

    public void likesByPhotoId(){
        int photoId1;
        System.out.println("Introduceti id-ul pozei: ");
        photoId1=Integer.parseInt(scanner.nextLine());
        int numar= likeRepository.likesByPhotoId(photoId1);
        System.out.println("Numarul de like-uri pentru poza selectata este: "+ numar);
    }

    public void showPhotosByUsername() {
        System.out.println("Introduceti username-ul persoanei caruia vreti sa ii vedeti pozele:");
        String username = scanner.nextLine();
        int id1 = userRepository.getIdByUsername(username);
        List<Photo> poze = photoRepository.getPhotosByUserId(id1);
        if (poze.isEmpty()) {
            System.out.println("Nu exista poze pe acest profil");
        } else {
            for (Photo photo : poze) {
                System.out.println(photo.getImageUrl());
            }
        }
    }

    public void likeAPhoto() {
        System.out.println("Introduceti numele persoanei caruia vreti sa ii vizualizati profilul:");
        String name1=scanner.nextLine();
        System.out.println("User-ul cautat:" + userRepository.getUserByName(name1).getUsername());
        List<Photo> poze= photoRepository.getPhotosByUserId(userRepository.getIdByUsername(name1));
        System.out.println("Pozele acestui user: ");
        for (Photo photo1:poze){
            System.out.println(photo1.getImageUrl());
        }
        System.out.println("Id-ul pozei pe care vreti sa o apreciati (ultimele cifre din link): ");
        int id= Integer.parseInt(scanner.nextLine());
        try {
            likeCommandService.add(new Like(this.admin.getId(),id, LocalDate.now()));
        } catch (YouAlreadyLikedThePhotoException e) {
            System.out.println("Nu poti aprecia de 2 ori aceeasi postare");
        }
        System.out.println("Apreciat!");




    }
}
