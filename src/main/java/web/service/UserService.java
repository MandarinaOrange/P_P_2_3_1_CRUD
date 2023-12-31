package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    int changeUser(User user);

    User findUser(int id);

    List<User> showUsers();
}
