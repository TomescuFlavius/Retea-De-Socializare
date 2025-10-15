package app.service;

import app.exceptions.UserNotFoundException;
import app.users.User;

import java.util.List;

public interface UserQueryService {
    List<User> getAllUsers();
    User getUserById(int id) throws UserNotFoundException;
    List<User> getAllUsersByIds(List<Integer> userIds);
}
