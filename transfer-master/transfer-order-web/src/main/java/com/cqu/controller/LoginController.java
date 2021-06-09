package com.cqu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.cqu.pojo.User;
import com.cqu.mapperservice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    DefaultMQPushConsumer consumer;


    @Value("${mq.task.result.topic}")
    private String topic;


    @GetMapping("/login")
    public String login(){
        return "login"; // 转到login.html
    }

    @PostMapping("/login")
    public String login(User user, HttpSession httpSession, Model model) throws MQClientException {

        //保存登录成功的页面session
        //session.setAttribute

        QueryWrapper<User> queryWrapper= new QueryWrapper<>();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        User user1=userService.selectUser(queryWrapper);
        System.out.println(user1);
        if(user1!=null){
            log.info("登录成功");

            httpSession.setAttribute("loginUser",user);
            consumer.subscribe(topic,Long.toString(user1.getUserId()));
            consumer.start();
            log.info("consumer启动成功");

            return "redirect:/service";

        }else{
            log.warn("你输入的账号不存在");
        }

        return "login";

    }




}
