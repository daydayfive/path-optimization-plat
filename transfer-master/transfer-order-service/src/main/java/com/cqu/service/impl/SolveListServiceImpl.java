package com.cqu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqu.mapper.SolveListMapper;
import com.cqu.pojo.SolveList;
import com.cqu.service.SolveListService;
import org.springframework.stereotype.Service;


@Service
public class SolveListServiceImpl extends ServiceImpl<SolveListMapper, SolveList> implements SolveListService {
    @Override
    public void insertSolveList(SolveList solveList) {
        getBaseMapper().insert(solveList);
    }
}
