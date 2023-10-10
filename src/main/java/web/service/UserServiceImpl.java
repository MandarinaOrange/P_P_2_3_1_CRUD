package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public int changeUser(int id) {
        return userDao.changeUser(id);
    }
}
