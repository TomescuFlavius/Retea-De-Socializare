package app.tags.repository;

import app.tags.models.Tag;

import java.util.List;

public interface TagRepository {
    Tag add(Tag tag);
    Tag delete(Tag tag);
    List<Tag> getAllTags();
}
