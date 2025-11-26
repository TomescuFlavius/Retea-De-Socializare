package app.photoTag.repository;

import app.photoTag.repository.PhotoTagRepository;
import app.photos.models.PhotoTag;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhotoTagRepositoryImpl implements PhotoTagRepository {

    private File file;
    private List<PhotoTag> photoTags;

    // Ajustează calea către fișierul photoTag.txt
    public PhotoTagRepositoryImpl(){
        file = new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\photos\\repository\\photoTag.txt");
        photoTags = new ArrayList<>();
        loadPhotoTags();
    }

    public void loadPhotoTags(){
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                photoTags.add(new PhotoTag(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toString(){
        StringBuilder text = new StringBuilder();
        for (PhotoTag pt : photoTags){
            text.append(pt.toString()).append("\n");
        }
        return text.toString();
    }

    public void savePhotoTags(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.file))){
            writer.print(this.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Metodă ajutătoare pentru a verifica existența unei relații
    private PhotoTag getPhotoTagByKeys(int photoId, int tagId){
        return photoTags.stream()
                .filter(pt -> pt.getPhotoId() == photoId && pt.getTagId() == tagId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public PhotoTag add(PhotoTag photoTag) {
        if (getPhotoTagByKeys(photoTag.getPhotoId(), photoTag.getTagId()) == null) {
            this.photoTags.add(photoTag);
            savePhotoTags();
            return photoTag;
        }
        return null; // Relația există deja
    }

    @Override
    public PhotoTag delete(PhotoTag photoTag) {
        this.photoTags.remove(photoTag);
        savePhotoTags();
        return photoTag;
    }

    @Override
    public List<PhotoTag> getTagsByPhotoId(int photoId) {
        return photoTags.stream()
                .filter(pt -> pt.getPhotoId() == photoId)
                .collect(Collectors.toList());
    }

    @Override
    public List<PhotoTag> getPhotosByTagId(int tagId) {
        return photoTags.stream()
                .filter(pt -> pt.getTagId() == tagId)
                .collect(Collectors.toList());
    }
}