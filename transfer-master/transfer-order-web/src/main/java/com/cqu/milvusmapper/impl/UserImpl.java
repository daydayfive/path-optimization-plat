package com.cqu.milvusmapper.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqu.mapper.UserMapper;
import com.cqu.pojo.User;
import com.cqu.milvusmapper.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectUser(Wrapper<User> queryWrapper) {

        return getBaseMapper().selectOne(queryWrapper);
    }

}
