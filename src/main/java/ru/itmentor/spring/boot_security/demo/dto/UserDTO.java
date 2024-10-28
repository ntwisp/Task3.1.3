package ru.itmentor.spring.boot_security.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
    private String password;
    private Set<String> roles;

}
