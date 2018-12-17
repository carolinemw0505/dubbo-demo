package com.spring.dubbo.service.impl;

import com.spring.dubbo.dao.faceSystemDao;
import com.spring.dubbo.entity.User;
import com.spring.dubbo.service.faceSystemApi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class faceSystemApiImpl implements faceSystemApi {

    @Autowired
    private faceSystemDao fSystemDao;

    @Override
    public int addUser(User u)
    {
        return fSystemDao.addUser(u);
    }

    @Override
    public List<User> queryUser(long id)
    {
        return fSystemDao.queryUser(id);
    }
}
