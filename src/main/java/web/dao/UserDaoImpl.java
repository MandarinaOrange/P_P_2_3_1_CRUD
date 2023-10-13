package web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

import static web.config.DBConfig.*;
//import static web.model.ListPeople.USERS;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {



    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }


    @Override
    public int changeUser(int id) {
        return 0;
    }

    @Override
    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(findUser(id));
    }

    @Override
    @SuppressWarnings("unckecked")
    public List<User> showUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();

    }
}
