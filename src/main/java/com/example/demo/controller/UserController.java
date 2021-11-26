package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        return ResponseEntity.ok("user-ws is up and running on port: "+environment.getProperty("local.server.port"));
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=modelMapper.map(userRequestModel,UserDto.class);
        String str[]=UUID.randomUUID().toString().split("-");
        userDto.setUniqueId(str[0]);
        UserDto temp=userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(temp,UserResponseModel.class));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseModel>> displayUsers()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserDto> userDtoList=userService.displayAllUser();
        List<UserResponseModel> userResponseModelList=new ArrayList<>();
        Iterator<UserDto> iterator=userDtoList.iterator();
        while(iterator.hasNext())
        {
            userResponseModelList.add(modelMapper.map(iterator.next(),UserResponseModel.class));
        }
        return ResponseEntity.ok(userResponseModelList);
    }

    @GetMapping("/users/{uniqueId}")
    public ResponseEntity<UserResponseModel> fetUserByUniqueId(@PathVariable("uniqueId") String uniqueId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(userService.fetchUserByUniqueId(uniqueId),UserResponseModel.class));
    }
}
