package com.cqu.milvusmapper.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqu.mapper.UserInfoMapper;
import com.cqu.pojo.UserInfo;
import com.cqu.milvusmapper.UserInfoService;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
