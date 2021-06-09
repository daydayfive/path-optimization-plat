package com.cqu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.pojo.Solution;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SolutionService extends IService<Solution> {


    //查询mivus-id 的task 并判断是否优解，返回有解的相似任务
    Long getSimilarTask(Long id);
}
