package com.cqu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.mapper.SolutionMapper;
import com.cqu.pojo.Solution;

import com.cqu.service.SolutionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SolutionServiceImpl extends ServiceImpl<SolutionMapper, Solution> implements SolutionService {

    @Override
    public Long getSimilarTask(Long id) {
        SolutionMapper baseMapper = getBaseMapper();
        QueryWrapper<Solution> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("milvs_id",id);
        queryWrapper.eq("is_solved",1);

        return baseMapper.selectOne(queryWrapper).getTaskId();
    }
}
