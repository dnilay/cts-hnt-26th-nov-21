package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private Environment environment;
    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(Environment environment, UserService userService, ModelMapper modelMapper) {
        this.environment = environment;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("user-ws is up and runing on port: "+environment.getProperty("local.server.port"));
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=modelMapper.map(userRequestModel,UserDto.class);
        userDto.setUniqueId(UUID.randomUUID().toString());
        UserDto temp=userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(temp,UserResponseModel.class));
    }
}
