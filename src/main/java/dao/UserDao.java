package dao;

import model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    void addUser (User user);
    void delUser (User user);
    void readUser (User user);
    void updateUser (User user);

}
