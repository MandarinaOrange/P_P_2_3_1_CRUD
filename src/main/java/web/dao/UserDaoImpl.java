package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    public void addUser(User user) {

    }

    public void deleteUser(int id) {

    }

    public int changeUser(int id) {
        return 0;
    }

    @Override
    public List<User> showUsers() {
        return null;
    }
}
