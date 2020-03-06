package com.ac.backend.service;

import com.ac.backend.dto.UserDto;
import com.ac.backend.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByEmail(String email);
    public User createNewAccount(UserDto userDto);
    public void saveUser(User user);
}
