package com.example.demo.dao;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,Integer> {

    @Query
    public UserEntity findByUniqueId(String uniqueId);
}
