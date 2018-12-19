package com.egoo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spring.dubbo.entity.User;
import com.spring.dubbo.service.faceSystemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Reference
//    @Autowired
    private faceSystemApi fSystemService;

    @RequestMapping(value="/queryUser",method = RequestMethod.GET)
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        Long id=Long.parseLong(request.getParameter("id"));
        List<User> u=fSystemService.queryUser(id);

        if(!u.isEmpty()){
            System.out.println("查询到的用户列表的第一个用户的相关信息为:"+u.get(0).getUsername()+":"+u.get(0).getRegIp());
        }
        return "index";
    }
}
