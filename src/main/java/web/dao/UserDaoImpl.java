package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public int changeUser(int id) {
        return 0;
    }

    @Override
    @SuppressWarnings("unckecked")
    public List<User> showUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User ");
        return query.getResultList();
    }
}
