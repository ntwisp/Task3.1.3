package ru.itmentor.spring.boot_security.demo.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.dto.UserDTO;
import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper mapper;
    private final RoleRepository roleRepository;

    public User toEntity(UserDTO userDto) {
        Set<Role> roles = new HashSet<>();
        for (String roleName : userDto.getRoles()) {
            roles.add(roleRepository.findByName(roleName));
        }
        User user = mapper.map(userDto, User.class);
        user.setRoles(roles);
        return user;
    }

    public UserDTO toDto(User user) {
       Set<String> roles = user.getRoles()
               .stream()
               .map(Role::getName)
               .collect(Collectors.toSet());
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        userDTO.setRoles(roles);
        return userDTO;
    }
}