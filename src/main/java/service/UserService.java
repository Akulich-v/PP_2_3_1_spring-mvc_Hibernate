package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> outputUsers();

    User outputUser(long id);

    void createUser(User user);

    void deleteUser(long id);

    void editUser(long id, User user);
}
