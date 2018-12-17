package com.spring.dubbo.dao;

import com.spring.dubbo.entity.User;

import java.util.List;

public interface faceSystemDao {
    int addUser(User u);

    List<User> queryUser(Long id);
}
