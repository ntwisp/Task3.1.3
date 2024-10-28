package ru.itmentor.spring.boot_security.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.mappers.UserMapper;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.toDto(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(UserDTO userdto) {
        User user = userMapper.toEntity(userdto);
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userdto, Long id) {
        User user = userMapper.toEntity(userdto);
        user.setId(id);
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        userRepository.save(user);
        return userdto;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndFetchLazyRelationEagerly(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}