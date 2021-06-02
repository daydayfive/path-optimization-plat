package com.cqu.milvusmapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.pojo.TaskFeature;


import java.io.Serializable;

public interface TaskFeatureService extends IService<TaskFeature> {


    @Override
    default TaskFeature getById(Serializable id) {
        return getBaseMapper().selectById(id);
    }
}
