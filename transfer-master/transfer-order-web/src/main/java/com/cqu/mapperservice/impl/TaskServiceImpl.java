package com.cqu.mapperservice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqu.mapper.TaskMapper;
import com.cqu.pojo.Task;
import com.cqu.mapperservice.TaskService;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Override
    public void insertTask(Task task){
        getBaseMapper().insert(task);
    }




}
