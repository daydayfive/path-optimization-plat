package com.cqu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.pojo.Task;
import com.cqu.pojo.TaskFeature;
import org.apache.ibatis.annotations.Mapper;


import java.io.Serializable;

@Mapper
public interface TaskFeatureService extends IService<TaskFeature> {


    void insertOne(TaskFeature taskFeature);




}
