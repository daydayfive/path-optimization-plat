package com.cqu.api.impl;

import com.cqu.api.TaskFeatureMakeService;

import com.cqu.pojo.Feature;
import com.cqu.pojo.TaskFeature;
import com.cqu.pojo.TaskInfo;
import org.apache.dubbo.config.annotation.DubboService;


@DubboService(version = "1.0.0")
class TaskFeatureMakeServiceImpl implements TaskFeatureMakeService {
    @Override
    public Feature generateFeatrue(TaskInfo taskInfo) {

        Feature feature=new Feature();
        // 调用python 代码来提取模块特征


        //

        return feature;
    }
}
