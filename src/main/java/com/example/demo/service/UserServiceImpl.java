package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UniqueIdNotFoundException;
import com.example.demo.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private ModelMapper modelMapper;
    private UserDao userDao;

    public UserServiceImpl(ModelMapper modelMapper, UserDao userDao) {
        this.modelMapper = modelMapper;
        this.userDao = userDao;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);
         UserEntity temp=userDao.save(userEntity);
         return modelMapper.map(temp,UserDto.class);
    }

    @Override
    public List<UserDto> displayAllUser() {
        List<UserEntity> userEntityList=userDao.findAll();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<UserDto> userDtoList=new ArrayList<>();
        Iterator<UserEntity> iterator=userEntityList.iterator();
        while(iterator.hasNext())
        {
            userDtoList.add(modelMapper.map(iterator.next(),UserDto.class));
        }
        return userDtoList;
    }

    @Override
    public UserDto fetchUserByUniqueId(String uniqueId) {
        UserEntity userEntity=userDao.findByUniqueId(uniqueId);
        if (userEntity==null)
        {
            throw new UniqueIdNotFoundException("id not found");
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(userDao.findByUniqueId(uniqueId),UserDto.class);
    }
}
