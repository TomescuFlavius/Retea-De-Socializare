package app.users.services;

import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserNotFoundException;
import app.users.models.User;

public interface UserCommandService {
    User add(User user) throws UserAlreadyExistException;
    User deleteUser(User user) throws UserNotFoundException;

}
