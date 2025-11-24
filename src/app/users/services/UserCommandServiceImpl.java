package app.users.services;
import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserNotFoundException;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;

import java.util.Optional;


public class UserCommandServiceImpl implements UserCommandService {

    private UserRepository userRepository;

    public UserCommandServiceImpl(){
        this.userRepository= UserRepositorySingleton.getInstance();
    }

    @Override
    public User add(User user) throws UserAlreadyExistException {
        if (Optional.ofNullable(userRepository.getUserByUsername(user.getUsername())).isPresent()) {
            throw new UserAlreadyExistException();
    }
        return userRepository.add(user);
    }

    @Override
    public User deleteUser(User user) throws UserNotFoundException {
        Optional.ofNullable(userRepository.getUserByUsername(user.getUsername()))
                .orElseThrow(UserNotFoundException::new);
        return userRepository.delete(user);
    }
}
