package com.cqu.pojo;


//求解清单

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolveList {







    //是否已经完成
    @TableId(value="solve_id",type= IdType.AUTO)
    // 任务编号
    private Long listId;
    //待求解任务id
    private Long optimizedId;
    //相似任务id
    private Long similarTaskId;
    // 是否完成，0未完成，1完成
    private int isOptimized;



    private Date createTime;

    private Date lastEditTime;


}
