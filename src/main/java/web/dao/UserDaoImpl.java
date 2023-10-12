package web.dao;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.ListPeople;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

import static web.model.ListPeople.USERS;
import static web.model.ListPeople.USSERS;


@Repository
public class UserDaoImpl implements UserDao {

/*    @PersistenceContext
    private EntityManager entityManager;*/
    @Override
    public void addUser(User user) {
        /*entityManager.persist(user);
        entityManager.flush();*/
        USERS.add(user);
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
        //TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User ");
        //return query.getResultList();
        return USERS;

    }
}
