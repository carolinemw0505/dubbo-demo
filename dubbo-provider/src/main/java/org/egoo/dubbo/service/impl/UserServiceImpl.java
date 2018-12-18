package org.egoo.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.egoo.dubbo.core.UserService;
import org.egoo.dubbo.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//dubbo注解
@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public List getBooksList(int offset, int limit) {
    	LOGGER.info("UserServiceImpl.getBooksList start");
    	
    	List userList=userDao.queryAll(offset, limit);
    	
        return userList;
    }


}
