package app.tags.services;

import app.tags.models.Tag;

import java.util.List;

public interface TagQueryService {
    List<Tag> getAllTags();
}
