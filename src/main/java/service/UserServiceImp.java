package service;

import dao.UserDaoImp;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    UserDaoImp userDaoImp = new UserDaoImp();
    @Override
    public List<User> index() {
        return userDaoImp.index();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void delUser(User user) {

    }

    @Override
    public void readUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
