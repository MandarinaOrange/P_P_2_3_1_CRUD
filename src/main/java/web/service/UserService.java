package web.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(Integer id);
    void changeUser(User user);

    User findUser(Integer id);

    List<User> showUsers();
}
