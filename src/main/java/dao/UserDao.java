package dao;

import model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(long id);

    void save(User user);

    void delUser(long id);

    void updateUser(long id, User user);

}
