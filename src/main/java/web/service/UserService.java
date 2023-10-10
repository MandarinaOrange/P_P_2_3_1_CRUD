package web.service;

import web.model.User;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    int changeUser(int id);
}
