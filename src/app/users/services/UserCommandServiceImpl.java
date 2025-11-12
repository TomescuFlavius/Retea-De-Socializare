package app.users.services;
import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserNotFoundException;
import app.users.models.User;
import app.users.repository.UserRepository;
import app.users.repository.UserRepositorySingleton;


public class UserCommandServiceImpl implements UserCommandService {

    private UserRepository userRepository;

    public UserCommandServiceImpl(){
        this.userRepository= UserRepositorySingleton.getInstance();
    }

    @Override
    public User add(User user) throws UserAlreadyExistException {
         if(userRepository.getUserByUsername(user.getUsername())!=null){
             throw  new UserAlreadyExistException();
         }
        return userRepository.add(user);
    }

    @Override
    public User deleteUser(User user) throws UserNotFoundException {
        if (userRepository.getUserByUsername(user.getUsername())==null){
            throw new UserNotFoundException();
        }
        return userRepository.delete(user);
    }
}
