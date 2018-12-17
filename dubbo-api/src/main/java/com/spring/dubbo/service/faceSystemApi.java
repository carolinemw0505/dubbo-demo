package com.spring.dubbo.service;

import com.spring.dubbo.entity.User;

import java.util.List;

public interface faceSystemApi {
    int addUser(User u);

    List<User> queryUser(long id);
}
