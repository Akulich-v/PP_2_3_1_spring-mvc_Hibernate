package dao;

import model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserDao {
    List<User> outputUsers();

    User outputUser(long id);

    void createUser(User user);

    void deleteUser(long id);

    void editUser(long id, User user);

}
