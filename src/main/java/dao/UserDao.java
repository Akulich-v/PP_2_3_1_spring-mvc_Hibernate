package dao;

import model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void delete(long id);

    void update(long id, User user);

}
