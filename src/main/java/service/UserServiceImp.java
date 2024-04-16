package service;

import dao.UserDao;
import dao.UserDaoImp;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> outputUsers() {
        return userDao.outputUsers();
    }

    @Override
    public User outputUser(long id) {
        return userDao.outputUser(id);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void editUser(long id, User user) {
        userDao.editUser(id, user);
    }
}
