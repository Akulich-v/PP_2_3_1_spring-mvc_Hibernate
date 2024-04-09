package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    void addUser (User user);
    void delUser (User user);
    void readUser (User user);
    void updateUser (User user);
}
