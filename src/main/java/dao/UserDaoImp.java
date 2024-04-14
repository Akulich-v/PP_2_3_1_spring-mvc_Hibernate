package dao;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Transactional
    @Override
    public void delUser(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Transactional
    @Override
    public void updateUser(long id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        entityManager.merge(userToBeUpdated);
    }
}
