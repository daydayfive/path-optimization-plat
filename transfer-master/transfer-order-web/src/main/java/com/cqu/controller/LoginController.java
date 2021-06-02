package com.cqu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.cqu.pojo.User;
import com.cqu.milvusmapper.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


//处理账号登录的

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String login(){
        return "login"; // 转到login.html
    }

    @PostMapping("/login")
    public String login(User user, HttpSession httpSession, Model model){

        //保存登录成功的页面session
        //session.setAttribute

        QueryWrapper<User> queryWrapper= new QueryWrapper<>();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        if(userService.selectUser(queryWrapper)!=null){
            log.info("登录成功");
            httpSession.setAttribute("loginUser",user);
            return "redirect:/service";

        }else{
            log.warn("你输入的账号不存在");
        }

        return "login";

    }




}
