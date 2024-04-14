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
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delUser(long id) {
        userDao.delUser(id);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id, user);
    }
}
