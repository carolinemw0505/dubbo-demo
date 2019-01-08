package com.spring.test;

import com.spring.dubbo.dao.faceSystemDao;
import com.spring.dubbo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class mybatisTest {
    @Autowired
    faceSystemDao fSystemDao;

    @Test
    public void testDao(){
        List<User> u=fSystemDao.queryUser(1L);

        if (!u.isEmpty()) {
            System.out.println(u.get(0).getUsername() + ":" + u.get(0).getRegIp());
        }

        User a=new User();
        a.setId(10);
        a.setEmail("rrr@qq.com");
        a.setPassword("111");
        a.setUsername("rr");
        a.setRole("admin");
        a.setStatus(2);
        a.setRegIp("192.168.5.33");
        a.setRegTime(new Date());

        fSystemDao.addUser(a);
    }
}
