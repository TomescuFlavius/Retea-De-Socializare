package app.photos.services;

import app.photos.exceptions.PhotoNotFoundException;
import app.photos.models.Photo;
import app.photos.repository.PhotoRepositorySingleton;
import app.photos.repository.PhotoRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PhotoCommandServiceImpl implements PhotoCommandService {
    private PhotoRepository photoRepository;

    public PhotoCommandServiceImpl(){
        this.photoRepository= PhotoRepositorySingleton.getInstance();
    }

    @Override
    public Photo delete(Photo photo) throws PhotoNotFoundException {
        if (photoRepository.getPhotoById(photo.getId())==null){
            throw new PhotoNotFoundException();
        }
        return photoRepository.delete(photo);
    }
}
