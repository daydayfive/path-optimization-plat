package com.cqu;

import com.cqu.mapperservice.UserService;
import com.cqu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TransferOrderApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user=new User();
        user.setUserId(2l);
        user.setCreateTime(new Date());
        user.setLastEditTime(new Date());
        user.setUsername("gu");
        user.setPassword("123456");
        userService.insertUser(user);
    }

}
