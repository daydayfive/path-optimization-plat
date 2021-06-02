package com.cqu.milvusmapper.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqu.mapper.TaskFeatureMapper;
import com.cqu.pojo.TaskFeature;
import com.cqu.milvusmapper.TaskFeatureService;
import org.springframework.stereotype.Service;


@Service
public class TaskFeatureServiceImpl extends ServiceImpl<TaskFeatureMapper, TaskFeature> implements TaskFeatureService {
}
