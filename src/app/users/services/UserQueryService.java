package app.users.services;

import app.users.exceptions.UserNotFoundException;
import app.users.models.User;

public interface UserQueryService {
    User getUserById(int id) throws UserNotFoundException;




}
