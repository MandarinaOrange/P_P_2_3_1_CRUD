package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
    int changeUser(int id);

    User findUser(int id);

    List<User> showUsers();

}
