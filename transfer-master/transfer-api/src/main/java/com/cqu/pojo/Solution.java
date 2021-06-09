package com.cqu.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("solution")
public class Solution {
    @TableId(value="solution_id",type= IdType.AUTO)
    private Long solutionId;

    private Long taskId;

    private Long milvusId;

    private String solutionAddr;

    private int isSolved;

    private Date createTime;

    private Date lastEditTime;
}
