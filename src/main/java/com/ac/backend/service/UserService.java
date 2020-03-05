package com.ac.backend.service;

import com.ac.backend.dto.UserDto;
import com.ac.backend.entity.User;

public interface UserService {
    public User findByEmail(String email);
    public User createNewAccount(UserDto userDto);
    public void saveUser(User user);
}
