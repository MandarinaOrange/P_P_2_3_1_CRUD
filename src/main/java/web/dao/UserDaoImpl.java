package web.dao;


import org.springframework.stereotype.Repository;
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
import static web.model.ListPeople.USERS;


@Repository
public class UserDaoImpl implements UserDao {



    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        //USERS.add(user);
        entityManager.persist(user);
        entityManager.flush();
    }


    @Override
    public int changeUser(int id) {
        return 0;
    }

    @Override
    public User findUser(int id) {
        for (User user : USERS) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public void deleteUser(int id) {
        USERS = USERS.stream().filter(user -> user.getId() != id).collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("unckecked")
    public List<User> showUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
        //return USERS;

    }
}
