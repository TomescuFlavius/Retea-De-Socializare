package app.users.repository;

import app.users.comparators.UserComparatorById;
import app.users.comparators.UserComparatorByName;
import app.users.models.Admin;
import app.users.models.Client;
import app.users.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;
    private final File file;

    private UserRepository userRepository;

    public UserRepositoryImpl() {
        users = new ArrayList<>();
        this.file = new File("C:\\mycode\\oop\\mostenirea\\retea-de-socializare\\src\\app\\users\\repository\\users.txt");
        this.loadUsers();
    }

    public void loadUsers() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                switch (line.split(",")[0]) {
                    case "ADMIN" -> this.users.add(new Admin(line));
                    case "CLIENT" -> this.users.add(new Client(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public String toString() {
        String text = "";
        int i;
        for (i = 0; i < users.size() - 1; i++) {
            User user = users.get(i);
            text += user.toString() + "\n";
        }
        return users.get(i).toString() + "\n";
    }

    public void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.print(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private int RandomId() {
        Random random = new Random();
        int id = random.nextInt(100) + 1;
        return id;
    }

    private int generateId() {
        int id = RandomId();
        while (getUserById(id) != null) {
            id = RandomId();
        }
        return id;
    }

    public User add(User user) {
        user.setId(generateId());
        users.add(user);
        saveUsers();
        return user;
    }

    @Override
    public User delete(User user) {
        users.remove(user);
        saveUsers();
        return user;
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    @Override
    public List<User> getAllUsersById(List<Integer> userIds) {
        Set<Integer> ids = new HashSet<>(userIds);

        return users.stream()
                .filter(user -> ids.contains(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> showUsers() {
        return users;
    }

    @Override
    public User getUserByName(String name) {
        return users.stream()
                .filter(u -> u.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getIdByUsername(String name) {
        return users.stream()
                .filter(u -> u.getUsername().equals(name))
                .map(User::getId)
                .findFirst()
                .orElse(-1);
    }

    @Override
    public String getUsernameById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .map(User::getUsername)
                .findFirst()
                .orElse(null);
    }


}
