package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    int changeUser(int id);

    List<User> showUsers();
}
