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
@TableName("task_feature")
public class TaskFeature {
    @TableId(value="feature_id",type= IdType.AUTO)
    private Long featureId;

    private Long taskId;

    private Long milvusId;

    private String featureAddr;

    private Date createTime;

    private Date lastEditTime;
}
