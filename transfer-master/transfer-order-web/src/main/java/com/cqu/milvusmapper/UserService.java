package com.cqu.milvusmapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserService extends IService<User> {


    User selectUser(Wrapper<User> queryWrapper);



}
