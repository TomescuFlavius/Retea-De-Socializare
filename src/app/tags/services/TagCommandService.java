package app.tags.services;

import app.tags.models.Tag;

public interface TagCommandService {
    Tag add(Tag tag);
    Tag delete(Tag tag);
}
