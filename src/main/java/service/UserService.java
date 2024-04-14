package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(long id);
    void save (User user);
    void delUser (long id);
    void updateUser (long id, User user);
}
