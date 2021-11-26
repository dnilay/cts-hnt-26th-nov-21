package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    private UserDao userDao;

    public UserServiceApplication(UserDao userDao) {
        this.userDao = userDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        userDao.save(new UserEntity(1, "uid-1","John","Doe","john@email.com"));
        userDao.save(new UserEntity(2, "uid-2","Marry","Public","marry@email.com"));
        userDao.save(new UserEntity(3, "uid-3","Oak","Smith","oak@email.com"));
        userDao.save(new UserEntity(1, "uid-4","Daniel","Doe","daniel@email.com"));

    }
}
