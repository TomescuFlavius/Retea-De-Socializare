package app.users.repository;

import app.users.models.User;

import java.util.List;

public interface UserRepository {

     User getUserById(int id);
     User add(User user);
     User delete(User user);
     void saveUsers();
     String toString();
     void loadUsers();
     User getUserByUsername(String username);
     List<User> getAllUsers();
     List<User> getAllUsersById(List<Integer> userIds);
     List<User> showUsers();
     User getUserByName(String name);
     int getIdByUsername(String name);
     String getUsernameById(int id);
}
