package ru.itmentor.spring.boot_security.demo.dao;

import ru.itmentor.spring.boot_security.demo.models.User;
import java.util.List;

public interface UserDAO {
    User findUserByUsername(String username);
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void deleteById(long id);
}
