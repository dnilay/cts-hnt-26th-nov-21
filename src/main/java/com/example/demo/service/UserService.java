package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto userDto);
    public List<UserDto> displayAllUser();

    public UserDto fetchUserByUniqueId(String uniqueId);
}
