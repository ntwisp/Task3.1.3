package ru.itmentor.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.models.User;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();
    UserDTO findByUsername(String username);
    User findById(Long id);
    void save(UserDTO userdto);
    UserDTO update(UserDTO user, Long id);
    void delete(Long id);

}