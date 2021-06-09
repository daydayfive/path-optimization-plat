package com.cqu.mapperservice.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqu.mapper.UserMapper;
import com.cqu.pojo.User;
import com.cqu.mapperservice.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectUser(Wrapper<User> queryWrapper) {

        return getBaseMapper().selectOne(queryWrapper);
    }

    public void insertUser(User user){
        getBaseMapper().insert(user);
    }
}
