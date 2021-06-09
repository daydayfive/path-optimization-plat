package com.cqu.mapperservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.pojo.Task;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskService extends IService<Task> {

   void insertTask(Task task);
}
