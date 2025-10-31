package app.tags.services;
import app.tags.repository.TagRepository;
import app.tags.repository.TagRepositorySingleton;

public class TagQueryServiceImpl implements TagQueryService{

    private TagRepository tagRepository;

    public TagQueryServiceImpl(){
        this.tagRepository= TagRepositorySingleton.getInstance();
    }


}
