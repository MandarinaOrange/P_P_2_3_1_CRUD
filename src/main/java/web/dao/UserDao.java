package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
    int changeUser(int id);
}
