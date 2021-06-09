package com.cqu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqu.mapper.TaskFeatureMapper;
import com.cqu.pojo.TaskFeature;
import com.cqu.service.TaskFeatureService;
import org.springframework.stereotype.Service;


@Service
public class TaskFeatureServiceImpl extends ServiceImpl<TaskFeatureMapper, TaskFeature> implements TaskFeatureService {


    @Override
    public void insertOne(TaskFeature taskFeature) {
        getBaseMapper().insert(taskFeature);
    }
}
