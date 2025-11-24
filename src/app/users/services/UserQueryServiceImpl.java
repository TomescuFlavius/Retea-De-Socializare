package app.users.services;
import app.users.exceptions.UserNotFoundException;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;

import java.util.Optional;


public class UserQueryServiceImpl implements UserQueryService {

    private UserRepository userRepository;

    public UserQueryServiceImpl(){
        this.userRepository= UserRepositorySingleton.getInstance();
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException{
        return Optional.ofNullable(userRepository.getUserById(id))
                .orElseThrow(UserNotFoundException::new);
    }







}
