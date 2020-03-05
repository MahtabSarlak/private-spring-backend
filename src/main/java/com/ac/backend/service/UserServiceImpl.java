package com.ac.backend.service;

import com.ac.backend.entity.User;
import com.ac.backend.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ac.backend.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User createNewAccount(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
 /*       user.setRoles(Collections.singletonList(roleService.findByName("ROLE_USER")));*/
        return user;
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }

}