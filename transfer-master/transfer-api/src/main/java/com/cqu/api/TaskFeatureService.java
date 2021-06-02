package com.cqu.api;


import com.cqu.pojo.Feature;
import com.cqu.pojo.TaskFeature;
import com.cqu.pojo.TaskInfo;

public interface TaskFeatureService {

    /**
     *   任务特征生成接口
     * @param  TaskInfo
     */
    Feature generateFeatrue(TaskInfo taskInfo);



}
