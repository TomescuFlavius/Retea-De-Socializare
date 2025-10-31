package app.users.services;
import app.users.exceptions.UserNotFoundException;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;


public class UserQueryServiceImpl implements UserQueryService {

    private UserRepository userRepository;

    public UserQueryServiceImpl(){
        this.userRepository= UserRepositorySingleton.getInstance();
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException{
        if (userRepository.getUserById(id)==null){
            throw new UserNotFoundException();
        }
        return userRepository.getUserById(id);
    }







}
