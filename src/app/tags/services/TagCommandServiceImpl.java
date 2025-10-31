package app.tags.services;
import app.tags.repository.TagRepository;
import app.tags.repository.TagRepositorySingleton;


public class TagCommandServiceImpl implements TagCommandService {

   private TagRepository tagRepository;

    public TagCommandServiceImpl(){
        tagRepository= TagRepositorySingleton.getInstance();
    }


}
