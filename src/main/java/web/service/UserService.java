package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    void deleteUser(Integer id);
    boolean existUser(Integer id);
    void changeUser(User user);

    Optional<User> findUser(Integer id);

    List<User> showUsers();
}
