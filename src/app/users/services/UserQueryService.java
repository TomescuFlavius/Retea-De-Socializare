package app.users.services;

import app.users.exceptions.UserNotFoundException;
import app.users.models.Admin;
import app.users.models.User;

import java.util.List;

public interface UserQueryService {
    User getUserById(int id) throws UserNotFoundException;




}
