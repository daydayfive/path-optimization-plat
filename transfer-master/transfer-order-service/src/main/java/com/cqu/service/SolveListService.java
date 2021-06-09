package com.cqu.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cqu.pojo.SolveList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SolveListService extends IService<SolveList> {

    void insertSolveList(SolveList solveList);

}
