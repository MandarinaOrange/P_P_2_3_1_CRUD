package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserServiceImpl(){}

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void changeUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean existUser(Integer id) {
        return userRepository.existsById(id);
    }
    @Transactional
    @Override
    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);


    }
    @Transactional
    @Override
    public List<User> showUsers() {
        return userRepository.findAll();
    }


}
