package app.service;

import app.exceptions.UserAlreadyExistException;
import app.exceptions.UserNotFoundException;
import app.users.User;

public interface UserCommandService {
    User add(User user) throws UserAlreadyExistException;
    User deleteUser(User user) throws UserNotFoundException;

}
